package id.ac.unand.klp_7_ptb_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class InputNilai : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_nilai)

        val btnbacinput = findViewById<ImageView>(R.id.backBtn)

        btnbacinput.setOnClickListener{
            Intent(this, DetailMahasiswa::class.java).also{
                startActivity(it)
            }
        }
    }
}