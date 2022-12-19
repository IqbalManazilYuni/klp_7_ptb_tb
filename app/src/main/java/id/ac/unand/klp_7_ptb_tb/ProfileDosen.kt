package id.ac.unand.klp_7_ptb_tb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityProfileDosenBinding
import id.ac.unand.klp_7_ptb_tb.models.LogoutResponse
import id.ac.unand.klp_7_ptb_tb.models.ProfileResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileDosen : AppCompatActivity() {

    lateinit var binding: ActivityProfileDosenBinding
    override fun onCreate(savedInstanceState: Bundle?) {



        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("token", "")

        if(token != null){
            Log.d("token", token)
            super.onCreate(savedInstanceState)
            binding = ActivityProfileDosenBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }

        val client: KpClient = NetworkConfig().getService()
        val call: Call<ProfileResponse> = client.profile(token = "Bearer "+token)

        call.enqueue(object: Callback<ProfileResponse> {
            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                Log.d("profile-debug",t.localizedMessage)
//                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ProfileResponse>, response: Response<ProfileResponse>) {

                val respon = response.body()
                Log.d("profile-debug",  "respon : "+ respon )

                val getNama = respon?.name
                binding.textuserdosen.text = getNama

                val email = respon?.email
                binding.textemaildosen.text = email

                val username = respon?.username
                binding.textnipdosen.text = username

            }

        })

        val btnlogout = binding.btnlogout

        btnlogout.setOnClickListener {
            if( token != null) {
                val client: KpClient = NetworkConfig().getService()
                val call: Call<LogoutResponse> = client.logout(token = "Bearer "+token)

                call.enqueue(object: Callback<LogoutResponse> {
                    override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                        Log.d("logout-debug",t.localizedMessage)
//                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(call: Call<LogoutResponse>, response: Response<LogoutResponse>) {

                        val respon = response.body()

                        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE) ?:return
                        with (sharedPref.edit()) {
                            putString("TOKEN", null)
                            apply()
                        }
                        Log.d("logout-debug",  "respon : "+ respon )
                        Toast.makeText(this@ProfileDosen, "Logout Berhasil", Toast.LENGTH_SHORT).show()
                        val logout = Intent(this@ProfileDosen, HalamanLoginApp::class.java)
                        logout.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(logout)
                        finish()
                    }

                })
            }

        }

        val btnbacpd = binding.backBtn
        btnbacpd.setOnClickListener{
            onBackPressed();
        }
        val btnResetPassword = findViewById<Button>(R.id.btnresetpass)

        btnResetPassword.setOnClickListener{
            Intent(this, UpdateProfile::class.java).also {
                startActivity(it)
            }
        }
        val btnupdate = binding.btnUpdateDosen

        btnupdate.setOnClickListener{
            Intent(this, ResetPassword::class.java).also{
                startActivity(it)
            }
        }
    }
}