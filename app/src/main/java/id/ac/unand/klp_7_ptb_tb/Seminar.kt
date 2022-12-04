package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDetailMahasiswaBinding
import id.ac.unand.klp_7_ptb_tb.databinding.ActivitySeminarBinding
import java.util.*

class Seminar : AppCompatActivity() {

    private lateinit var hadirRecyclerView: RecyclerView
    private lateinit var hadirArrayList: ArrayList<Hadir>
    lateinit var imgview: Array<Int>
    lateinit var nama_mahasiswa: Array<String>
    lateinit var nim_mahasiswa: Array<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminar)


        imgview = arrayOf(
            R.drawable.ic_profile_dash,
            R.drawable.ic_profile_dash,
            R.drawable.ic_profile_dash,
            R.drawable.ic_profile_dash,
            R.drawable.ic_profile_dash,
            R.drawable.ic_profile_dash,
            R.drawable.ic_profile_dash,
            R.drawable.ic_profile_dash,
            R.drawable.ic_profile_dash,
            R.drawable.ic_profile_dash,
        )

        nama_mahasiswa = arrayOf(
            "Deyola Fadwa Shifana",
            "Muhammad Erlangga",
            "Thomas Akram Ferdinan",
            "Ananda Fitria",
            "Shefilla R",
            "Zuha Bima",
            "Siti Nur Aisyah",
            "Boby Darmawan",
            "Yudhistira",
            "Fathih Alfi",
            "Salsabilla aca"
        )

        nim_mahasiswa = arrayOf(
            "2011522032",
            "2011523014",
            "2011521014",
            "2011522014",
            "2011523013",
            "2011523012",
            "2011521018",
            "2011522032",
            "2011522032",
            "2011522032",
        )

        hadirRecyclerView = findViewById(R.id.recycler_view)
        hadirRecyclerView.layoutManager = LinearLayoutManager(this)
        hadirRecyclerView.setHasFixedSize(true)

        hadirArrayList = arrayListOf<Hadir>()
        getUserdata()
    }

    private fun getUserdata(){

        for(i in imgview.indices){

            val hadir = Hadir(imgview[i],nama_mahasiswa[i], nim_mahasiswa[i])
            hadirArrayList.add(hadir)

        }

        hadirRecyclerView.adapter = SeminarAdapter(hadirArrayList)
    }

//        adapter.setOnItemClickListener(object : SeminarAdapter.onItemClickListener{
//            override fun onItemClick(position: Int) {
//                val intent = Intent(this@Seminar,DetailKegiatanLogbook::class.java)
//                intent.putExtra("tanggal",logbookArrayList[position].tanggal)
//                startActivity(intent)
//            }
//        })

}


