package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class InputNilai : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_nilai)

        val btntambah = findViewById<Button>(R.id.btntambah)

        btntambah.setOnClickListener{
            Intent(this, IsiNilaiMahasiswa::class.java).also{
                startActivity(it)
            }
        }
        val btnbacinput = findViewById<ImageView>(R.id.backBtn)

        btnbacinput.setOnClickListener{
            onBackPressed();
        }
    }
}