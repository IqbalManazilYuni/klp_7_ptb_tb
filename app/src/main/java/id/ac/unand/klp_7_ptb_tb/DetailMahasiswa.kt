package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailMahasiswa : AppCompatActivity(){

    private lateinit var adapter: LogBookAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var logbookArrayList: ArrayList<datalogbook>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_mahasiswa)
        val btnopsi = findViewById<Button>(R.id.btnopsi)
        btnopsi.setOnClickListener{
            val popupMenu: PopupMenu = PopupMenu(this,btnopsi)
            popupMenu.menuInflater.inflate(R.menu.menu_item,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.l_inputnilai ->{
                        val pinda = Intent(this@DetailMahasiswa,InputNilai::class.java)
                        startActivity(pinda)
                    }
                    R.id.l_seminar ->{
                        val pinda = Intent(this@DetailMahasiswa,Seminar::class.java)
                        startActivity(pinda)
                    }
                    R.id.l_pembatalan ->{
                        val pinda = Intent(this@DetailMahasiswa,PembatalanKp::class.java)
                        startActivity(pinda)
                    }
                }
                true
            })
            popupMenu.show()
        }
        val btnbackdetailtodash = findViewById<ImageView>(R.id.backBtn)

        btnbackdetailtodash.setOnClickListener{
            Intent(this, DashboardKp::class.java).also{
                startActivity(it)
            }
        }

        recyclerView = findViewById(R.id.recycler_view_2)
        recyclerView.layoutManager = LinearLayoutManager(this)

        logbookArrayList = ArrayList()

        logbookArrayList.add(datalogbook(hari = "Senin", tanggal = "6 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Selasa", tanggal = "7 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Rabu", tanggal = "8 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Kamis", tanggal = "9 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Jumat", tanggal = "10 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Senin", tanggal = "11 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Selasa", tanggal = "12 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Rabu", tanggal = "13 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Kamis", tanggal = "14 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Jumat", tanggal = "15 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Senin", tanggal = "16 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Selasa", tanggal = "17 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Rabu", tanggal = "18 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Kamis", tanggal = "19 Oktober 2022"))
        logbookArrayList.add(datalogbook(hari = "Jumat", tanggal = "20 Oktober 2022"))

        adapter = LogBookAdapter(logbookArrayList)
        recyclerView.adapter = adapter

    }

}