package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityHalamanLoginAppBinding
import id.ac.unand.klp_7_ptb_tb.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HalamanLoginApp : AppCompatActivity() {
    lateinit var binding: ActivityHalamanLoginAppBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalamanLoginAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            val TAG = "LoginActivity-Debug"
//            if (!task.isSuccessful) {
//                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
//                return@OnCompleteListener
//            }
//            val token = task.result
//
//            // Log and toast
//            Log.d(TAG, token)
//            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
//        })
        val btnlogin = binding.btnlogin

        //cek ada token atau ndak, kalo ada langsung ke MainActivity
        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val ada = sharedPref.getString("token",null)

        if (ada!=null){
            intent = Intent(applicationContext, DashboardKp::class.java)
            startActivity(intent)
            finish()
        }

        btnlogin.setOnClickListener{
            val username = binding.teksUsername.getText().toString()
            val password = binding.teksPassword.getText().toString()
            Log.d("login debug", username + " " + password)

            val client: KpClient = NetworkConfig().getService()

            val call: Call<LoginResponse> = client.login(username, password)

            call.enqueue(object : Callback<LoginResponse>{
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    //ambil respon login
                    val respon: LoginResponse? = response.body();
                    if (respon != null && respon.status == "success" ) {

                        //ambil Token
                        val token = respon.authorisation?.token

                        Log.d("login-debug",username +":"+ password +"|"+ token + "|" + respon)

                        //Shared Preference
                        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE) ?:return
                        with (sharedPref.edit()) {
                            putString("token", token)
                            apply()
                        }

                        Toast.makeText(this@HalamanLoginApp, "Login Berhasil", Toast.LENGTH_SHORT).show()

                        intent = Intent(applicationContext, DashboardKp::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this@HalamanLoginApp, "Username atau Password yang anda masukkan salah", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@HalamanLoginApp, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}