package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class IsiRespon : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_respon)

        val btnbacinpurespon = findViewById<ImageView>(R.id.backBtn)

        btnbacinpurespon.setOnClickListener{
            onBackPressed();
        }

        val btntambahrespon = findViewById<Button>(R.id.tambahrespon)
        btntambahrespon.setOnClickListener{
            Intent(this,DetailKegiatanLogbook::class.java).also {
                startActivity(it)
            }
        }
    }
}