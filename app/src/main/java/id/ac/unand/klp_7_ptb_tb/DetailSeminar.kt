package id.ac.unand.klp_7_ptb_tb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigator
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDetailSeminarBinding
import id.ac.unand.klp_7_ptb_tb.models.DetailSeminarResponse
import kotlinx.android.synthetic.main.activity_detail_seminar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailSeminar : AppCompatActivity() {
    lateinit var binding: ActivityDetailSeminarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSeminarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnbacinput = binding.backBtn

        btnbacinput.setOnClickListener{
            onBackPressed();
        }

        val detail_seminar_btn = binding.detailSeminarBtn
        detail_seminar_btn.setOnClickListener{
            val intent = Intent (this,Seminar::class.java)
            startActivity(intent)
        }

        val berita_acara_btn = binding.beritaAcaraBtn
        berita_acara_btn.setOnClickListener{
            val intent = Intent (this@DetailSeminar, BeritaAcara::class.java)
                startActivity(intent)
        }

        val sharedToken = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return

        val token = sharedToken.getString("token",null)
        val id = sharedToken.getInt("id",5)
        Log.d("Detail-seminar-debug","respon ")

        val client: KpClient = NetworkConfig().getService()
        val call: Call<DetailSeminarResponse> = client.detailSeminar(token = "Bearer"+token ,id)
        Log.d("Detail-seminar-debug","respon "+token.toString())
        call.enqueue(object : Callback<DetailSeminarResponse> {
            override fun onResponse(
                call: Call<DetailSeminarResponse>,
                response: Response<DetailSeminarResponse>
            ) {
                val respon = response.body()
                Log.d("Detail-seminar-debug-selalu-saja",respon.toString())
                if(respon!=null){
                    Log.d("Detail-seminar-debug-selalu",respon.toString())

                    val title = respon.title
                    binding.name.text = title.toString()
                    val nim = respon.nim
                    binding.nim.text = nim.toString()
                    val agency = respon.agency
                    binding.agency.text = agency.toString()
                    val supervisor = respon.supervisor
                    binding.supervisor.text = supervisor.toString()
                    val start_at = respon.startAt
                    binding.startAt.text = start_at.toString()
                    val end_at = respon.endAt
                    binding.endAt.text = end_at.toString()

                }
            }

            override fun onFailure(call: Call<DetailSeminarResponse>, t: Throwable) {
                Log.d("detail-debug", t.localizedMessage)
            }
        })

    }
}
