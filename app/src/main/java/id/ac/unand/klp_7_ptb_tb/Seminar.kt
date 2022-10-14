package id.ac.unand.klp_7_ptb_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Seminar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminar)

        val btnbackseminar = findViewById<ImageView>(R.id.backBtn)

        btnbackseminar.setOnClickListener{
            Intent(this, DetailMahasiswa::class.java).also{
                startActivity(it)
            }
        }
    }
}