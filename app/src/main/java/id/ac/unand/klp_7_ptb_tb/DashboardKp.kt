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
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDashboardKpBinding
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityHalamanLoginAppBinding
import id.ac.unand.tb_klp_7.MahasiswaAdapter

class DashboardKp : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mahasiswaList : ArrayList<mahasiswa>
    private lateinit var mahasiswaAdapter: MahasiswaAdapter

    lateinit var binding: ActivityDashboardKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnprofilegambar = binding.profileDosen

        btnprofilegambar.setOnClickListener{
            Intent(this, ProfileDosen::class.java).also{
                startActivity(it)
            }
        }
        val btntextgambar = binding.tekprofile

        btntextgambar.setOnClickListener{
            Intent(this, ProfileDosen::class.java).also{
                startActivity(it)
            }
        }
        //dimulai dari sini
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        mahasiswaList = ArrayList()

        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, "Iqbal Manazil Yuni", "201152xxxx", "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, "Deyola Fadwa Shifana", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, "Muhammad Erlangga", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Muhammad Yudishtira", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Kemal Muhammad Heiro", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Ilham", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Dzul Fauzi", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Muhammad Reza Riski Rahmadi", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Boby Dermawan", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))
        mahasiswaList.add(mahasiswa(R.drawable.ic_profile_dash, nama_mahasiswa = "Khalil Amir", nim_mahasiswa = "201152xxxx", lokasi_kp = "PT.Semen Padang"))

        mahasiswaAdapter = MahasiswaAdapter(mahasiswaList)
        recyclerView.adapter = mahasiswaAdapter

        mahasiswaAdapter.setOnItemClickListerner(object : MahasiswaAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@DashboardKp,DetailMahasiswa::class.java)
                intent.putExtra("nama",mahasiswaList[position].nama_mahasiswa)
                intent.putExtra("nim",mahasiswaList[position].nim_mahasiswa)
                intent.putExtra("tempat",mahasiswaList[position].lokasi_kp)
                startActivity(intent)
            }
        })
        //hingga sini
//        mahasiswaAdapter.onItemClick = {
//            val intent = Intent(this, DetailMahasiswa::class.java)
//            intent.putExtra("mahasiswa", it)
//            startActivity(intent)
//        }
    }
}