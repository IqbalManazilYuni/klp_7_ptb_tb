package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class IsiNilaiMahasiswa : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_nilai_mahasiswa)
        val btnbacinputnilai = findViewById<ImageView>(R.id.backBtn)

        btnbacinputnilai.setOnClickListener{
            onBackPressed();
        }

        val btntambahnilai = findViewById<Button>(R.id.adddatamaha)
        btntambahnilai.setOnClickListener{
            Intent(this,InputNilai::class.java).also {
                startActivity(it)
            }
        }
    }
}