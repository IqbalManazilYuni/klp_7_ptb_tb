package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Context
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

    }

}


