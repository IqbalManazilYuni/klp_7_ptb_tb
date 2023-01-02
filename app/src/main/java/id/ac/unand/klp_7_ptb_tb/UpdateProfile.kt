package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityUpdateProfileBinding
import id.ac.unand.klp_7_ptb_tb.models.UpdateProfileResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateProfile : AppCompatActivity() {
    lateinit var binding: ActivityUpdateProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("Nama")
        val getEmail = intent.getStringExtra("Email")
        binding.editTextTextEmailAddress.setText(getEmail)
        binding.editTextTextPersonName.setText(getNama)
        Log.d("update-debug", "")
        val btnbacup = binding.backBtn

        btnbacup.setOnClickListener{
            onBackPressed();
        }
        val btncancel = binding.cancelBtn

        btncancel.setOnClickListener{
            Intent(this, ProfileDosen::class.java).also{
                startActivity(it)
            }
        }


    }

    fun updateprofile(view: View) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("token",null)

        val name = binding.editTextTextPersonName.text.toString()
        val email = binding.editTextTextEmailAddress.text.toString()

        val client: KpClient = NetworkConfig().getService()
        val call: Call<UpdateProfileResponse> = client.updateProfile(token = "Bearer " + token,name,email)
        Log.d("update-debug", "$name|$email|Bearer $token")
        call.enqueue(object: Callback<UpdateProfileResponse> {
            override fun onFailure(call: Call<UpdateProfileResponse>, t: Throwable) {
                Log.d("update-debug",t.localizedMessage)
            }
            override fun onResponse(call: Call<UpdateProfileResponse>, response: Response<UpdateProfileResponse>) {
                Log.d("update-debug", "response : $response")

                val respon: UpdateProfileResponse? = response.body()
                if (respon != null && respon.status == "success" ) {

                    Log.d("update-debug", "$name:$email|$token|$respon")

                    Toast.makeText(this@UpdateProfile, "Berhasil Mengupdate Profile", Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, ProfileDosen::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@UpdateProfile, "Salah", Toast.LENGTH_SHORT).show()
                    Log.d("update-debug", "$name:$email|$token|$respon")
                }
            }
        })
    }
}