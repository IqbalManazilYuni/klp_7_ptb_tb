package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import id.ac.unand.tb_klp_7.MahasiswaAdapter

class DashboardKp : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mahasiswaList : ArrayList<mahasiswa>
    private lateinit var mahasiswaAdapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_kp)

        val btnprofilegambar = findViewById<ImageView>(R.id.profileDosen)

        btnprofilegambar.setOnClickListener{
            Intent(this, ProfileDosen::class.java).also{
                startActivity(it)
            }
        }
        val btntextgambar = findViewById<TextView>(R.id.tekprofile)

        btntextgambar.setOnClickListener{
            Intent(this, ProfileDosen::class.java).also{
                startActivity(it)
            }
        }

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mahasiswaList = ArrayList()

        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Iqbal Manazil Yuni", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Deyola Fadwa Shifana", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Muhammad Erlangga", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Muhammad Yudishtira", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Kemal Muhammad Heiro", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Ilham", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Dzul Fauzi", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Muhammad Reza Riski Rahmadi", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Boby Dermawan", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Khalil Amir", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))


        mahasiswaAdapter = MahasiswaAdapter(mahasiswaList)
        recyclerView.adapter = mahasiswaAdapter

        mahasiswaAdapter.onItemClick = {
            val intent = Intent(this, DetailMahasiswa::class.java)
            startActivity(intent)
        }
    }
}