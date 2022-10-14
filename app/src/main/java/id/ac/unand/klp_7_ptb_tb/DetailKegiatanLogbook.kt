package id.ac.unand.klp_7_ptb_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DetailKegiatanLogbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kegiatan_logbook)

        val pindahdetailkegiatan = findViewById<ImageView>(R.id.backBtn)
        pindahdetailkegiatan.setOnClickListener{
            Intent(this,DetailMahasiswa::class.java).also {
                startActivity(it)
            }
        }
    }
}