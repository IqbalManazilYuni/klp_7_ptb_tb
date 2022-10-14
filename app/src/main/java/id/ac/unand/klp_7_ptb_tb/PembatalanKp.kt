package id.ac.unand.klp_7_ptb_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PembatalanKp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembatalan_kp)

        val btnbackpembatalan = findViewById<ImageView>(R.id.backBtn)

        btnbackpembatalan.setOnClickListener{
            Intent(this, DetailMahasiswa::class.java).also{
                startActivity(it)
            }
        }
    }
}