package id.ac.unand.klp_7_ptb_tb


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDashboardKpBinding
import id.ac.unand.klp_7_ptb_tb.models.ListMahasiswa
import id.ac.unand.klp_7_ptb_tb.models.MahasiswaResponse
import id.ac.unand.tb_klp_7.MahasiswaAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardKp : AppCompatActivity() {

    lateinit var adapter: MahasiswaAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var binding: ActivityDashboardKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter: MahasiswaAdapter = MahasiswaAdapter()

        val sharedPrefToken = getSharedPreferences("sharedpref", MODE_PRIVATE) ?: return
        val token = sharedPrefToken.getString("token", null)
        val sharedPref = getSharedPreferences("mahapref", MODE_PRIVATE) ?: return
        val id = sharedPref.getInt("id", 2)

        val data = ArrayList<ListMahasiswa>()
        recyclerView = findViewById(R.id.recycler_view)

        Log.d("mahasiswa-debug", token.toString())
        val client: KpClient = NetworkConfig().getService()
        val call: Call<MahasiswaResponse> = client.listmahasiswa(token = "Bearer " + token)

        call.enqueue(object : Callback<MahasiswaResponse> {
            override fun onResponse(
                call: Call<MahasiswaResponse>,
                response: Response<MahasiswaResponse>
            ) {
                val respon = response.body()
                if (respon != null) {
                    val list: List<ListMahasiswa> = respon.internships as List<ListMahasiswa>
                    adapter.setlistMahasiswa(list)
                    Log.d("list-book-debug", list.toString())
                }
                Log.d("mahasiswa-debug", respon?.internships?.size.toString())
                Log.d("mahasiswa-debug", "respon : " + respon?.internships.toString())
            }

            override fun onFailure(call: Call<MahasiswaResponse>, t: Throwable) {
                Log.d("list-book-debug", t.localizedMessage)
            }
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MahasiswaAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@DashboardKp, DetailMahasiswa::class.java)
                startActivity(intent)
            }

        })
    }
}