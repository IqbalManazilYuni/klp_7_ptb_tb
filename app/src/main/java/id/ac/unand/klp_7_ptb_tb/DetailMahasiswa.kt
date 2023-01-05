package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDashboardKpBinding
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDetailMahasiswaBinding
import id.ac.unand.klp_7_ptb_tb.models.DetailMResponse
import id.ac.unand.klp_7_ptb_tb.models.ListMahasiswa
import id.ac.unand.klp_7_ptb_tb.models.MahasiswaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMahasiswa : AppCompatActivity(){

    lateinit var binding: ActivityDetailMahasiswaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val back = binding.backBtn
        back.setOnClickListener{
            val intent = Intent(this@DetailMahasiswa,DashboardKp::class.java)
            startActivity(intent)
        }

        val sharedTokennya = getSharedPreferences("sharedpref", MODE_PRIVATE)?: return
        val Detailpref = getSharedPreferences("Mahasiswapref", MODE_PRIVATE)?:return

        val token = sharedTokennya.getString("token",null)
        val id = sharedTokennya.getInt("id",2)
        val idl = Detailpref.getString("detailmahasiswa",null)
        Log.d("Detail-Mahasiswa-debug","respon "+idl.toString())

        val client: KpClient = NetworkConfig().getService()
        val call: Call<MahasiswaResponse> = client.detailmahasiswaKP(token = "Bearer"+token)
        Log.d("Detail-Mahasiwa-debug","respon "+token.toString())
        call.enqueue(object : Callback<MahasiswaResponse> {
            override fun onResponse(
                call: Call<MahasiswaResponse>,
                response: Response<MahasiswaResponse>
            ){
                val respon = response.body()
                Log.d("Detail-mahasiswa-debug-selalu-saja",respon.toString())
                if(respon!=null) {
                    Log.d("Detail-mahasiswa-debug-selalu", respon.toString())
                    val name = respon.internships
                    binding.name.text = name.toString()
                    val nim = respon.internships
                    binding.nim.text = nim.toString()
                    val agency = respon.internships
                    binding.agency.text = agency.toString()
                    val supervisor = respon.internships
                    binding.supervisor.text = supervisor.toString()

                }
            }
            override fun onFailure(call: Call<MahasiswaResponse>, t: Throwable) {
                Log.d("detail-debug", t.localizedMessage)
            }
        })

        val btnopsi = findViewById<Button>(R.id.btnopsi)
        btnopsi.setOnClickListener{
            val popupMenu: PopupMenu = PopupMenu(this,btnopsi)
            popupMenu.menuInflater.inflate(R.menu.menu_item,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.l_inputnilai ->{
                        val intent = Intent(this@DetailMahasiswa,InputNilai::class.java)
                        intent.putExtras(Bundle())
                        startActivity(intent)
                    }
                    R.id.l_seminar ->{
                        val pinda2 = Intent(this@DetailMahasiswa,Seminar::class.java)
                        startActivity(pinda2)
                    }
                    R.id.l_pembatalan ->{
                        val pinda3 = Intent(this@DetailMahasiswa,PembatalanKp::class.java)
                        startActivity(pinda3)
                    }
                }
                true
            })
            popupMenu.show()
        }






    }

}