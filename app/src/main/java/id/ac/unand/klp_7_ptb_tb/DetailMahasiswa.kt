package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDashboardKpBinding
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDetailMahasiswaBinding

class DetailMahasiswa : AppCompatActivity(){

    private lateinit var adapter: LogBookAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var logbookArrayList: ArrayList<datalogbook>
    lateinit var binding: ActivityDetailMahasiswaBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMahasiswaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle : Bundle? = intent.extras
        val nama = bundle!!.getString("nama")
        val nim = bundle!!.getString("nim")
        val tempat = bundle!!.getString("tempat")

        binding.valueNameDetail.text = nama
        binding.valueNimDetail.text = nim
        binding.valueTempatDetail.text = tempat

        val btnbacdetaillog = findViewById<ImageView>(R.id.backBtn)

        btnbacdetaillog.setOnClickListener{
            onBackPressed();
        }
        //narok data habis di intent
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
        recyclerView = findViewById(R.id.recycler_view_2)
        recyclerView.layoutManager = LinearLayoutManager(this)

        logbookArrayList = ArrayList()

        logbookArrayList.add(datalogbook( "Senin", "6 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Selasa",  "7 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Rabu",  "8 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Kamis",  "9 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Jumat",  "10 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Senin",  "11 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Selasa", "12 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Rabu",  "13 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Kamis",  "14 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Jumat",  "15 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Senin",  "16 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Selasa",  "17 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Rabu",  "18 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Kamis",  "19 Oktober 2022"))
        logbookArrayList.add(datalogbook( "Jumat",  "20 Oktober 2022"))

        adapter = LogBookAdapter(logbookArrayList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : LogBookAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@DetailMahasiswa,DetailKegiatanLogbook::class.java)
                intent.putExtra("tanggal",logbookArrayList[position].tanggal)
                startActivity(intent)
            }
        })
    }

}


