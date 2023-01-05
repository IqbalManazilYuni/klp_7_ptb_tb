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
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityBeritaAcaraBinding
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDetailSeminarBinding
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityIsiResponBinding
import id.ac.unand.klp_7_ptb_tb.models.InputBeritaAcaraResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeritaAcara : AppCompatActivity() {

    lateinit var binding: ActivityBeritaAcaraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeritaAcaraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnbacinpurespon = binding.backBtn
        btnbacinpurespon.setOnClickListener{
            val pindah1 = Intent(this,DashboardKp::class.java)
            startActivity(pindah1)
        }
    }

    fun onClicked(view: View) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?:return
        val token = sharedPref.getString("token",null)
        val id = sharedPref.getInt("id",2)
        val berita = binding.beritaacara.text.toString()

        val client: KpClient = NetworkConfig().getService()
        val call: Call<InputBeritaAcaraResponse> =client.isi_berita(token="Bearer " + token,id,berita)

        call.enqueue(object : Callback<InputBeritaAcaraResponse> {
            override fun onResponse(
                call: Call<InputBeritaAcaraResponse>,
                response: Response<InputBeritaAcaraResponse>
            ) {
                val respon : InputBeritaAcaraResponse?= response.body()
                Log.d("Isie","$berita|$respon")
                if(respon!=null && respon.status=="success"){
                    Log.d("Isi",respon.toString())
                    Toast.makeText(this@BeritaAcara, "Berhasil Membuat Berita Acara", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext,DetailSeminar::class.java)
                    startActivity(intent)
                    finish()
                }

            }

            override fun onFailure(call: Call<InputBeritaAcaraResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}