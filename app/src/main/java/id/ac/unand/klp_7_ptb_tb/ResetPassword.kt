package id.ac.unand.klp_7_ptb_tb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityResetPasswordBinding
import id.ac.unand.klp_7_ptb_tb.models.ChangePasswordResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResetPassword : AppCompatActivity() {
    lateinit var binding: ActivityResetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnbacrp = binding.backBtn

        btnbacrp.setOnClickListener{
            onBackPressed();
        }
        val btnBtlReset = binding.resetcancel

        btnBtlReset.setOnClickListener{
            Intent(this,ProfileDosen::class.java).also {
                startActivity(it)
            }
        }
    }

    fun savepasswordnew(view: View) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("token",null)

        val old_password = binding.editTextTextPasswordLama.text.toString()
        val new_password = binding.editTextTextPasswordbaru.text.toString()
        val confirm_password = binding.editTextTextPasswordkonfirmasi.text.toString()

        val client: KpClient = NetworkConfig().getService()
        val call: Call<ChangePasswordResponse> = client.changePassword(token = "Bearer " + token, old_password, new_password,confirm_password)
        Log.d("update-debug", "$old_password|$new_password|$confirm_password|Bearer $token")

        call.enqueue(object: Callback<ChangePasswordResponse> {
            override fun onFailure(call: Call<ChangePasswordResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<ChangePasswordResponse>, response: Response<ChangePasswordResponse>) {
                Log.d("update-debug", "response : $response")

                val respon: ChangePasswordResponse? = response.body()
                if (respon != null && respon.status == "success" && new_password == confirm_password) {

                    Log.d("update-debug", "$old_password:$new_password|$confirm_password|$token|$respon")

                    Toast.makeText(this@ResetPassword, "Password Berhasil Diupdate", Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, HalamanLoginApp::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@ResetPassword, "Password & Confirm Passowrd Salah", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}