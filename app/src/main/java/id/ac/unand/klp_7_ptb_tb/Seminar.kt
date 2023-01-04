package id.ac.unand.klp_7_ptb_tb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivitySeminarBinding
import id.ac.unand.klp_7_ptb_tb.models.SeminarInItem
import id.ac.unand.klp_7_ptb_tb.models.SeminarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class Seminar : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SeminarAdapter
    lateinit var binding: ActivitySeminarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeminarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SeminarAdapter()

        val sharedPrefToken = getSharedPreferences("sharedpref",Context.MODE_PRIVATE ) ?:return
        val token = sharedPrefToken.getString("token", null)
        val sharedPref = getSharedPreferences("mahapref",Context.MODE_PRIVATE) ?:return
        val id = sharedPref.getInt("id", 5)

        val data =ArrayList<SeminarInItem>()
        recyclerView = findViewById(R.id.recyle_view_3)

        Log.d("Seminar", token.toString())
        val client: KpClient = NetworkConfig().getService()
        val call: Call<SeminarResponse> = client.seminarlist(token = "Bearer" + token)

        call.enqueue(object : Callback<SeminarResponse> {
            override fun onResponse(
                call: Call<SeminarResponse>,
                response: Response<SeminarResponse>
            ) {

                val respon = response.body()
                if (respon != null){
                    val list : List<SeminarInItem> = respon.peserta as List<SeminarInItem>
                    adapter.setseminarList(list)
                    Log.d("Seminar", list.toString())
                }
                Log.d("Seminar", respon?.peserta?.size.toString())
                Log.d("Seminar", "respon : " +respon?.peserta.toString())
            }

            override fun onFailure(call: Call<SeminarResponse>, t: Throwable) {
                Log.d("Seminar", t.localizedMessage)
            }
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : SeminarAdapter.onItemClicklistener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@Seminar,DetailSeminar::class.java)
//
                startActivity(intent)
            }
        })

        val btnbacrp = binding.backBtn

        btnbacrp.setOnClickListener{
            onBackPressed()
        }
    }
}