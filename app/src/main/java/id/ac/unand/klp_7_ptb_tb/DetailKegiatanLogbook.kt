package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDetailKegiatanLogbookBinding

class DetailKegiatanLogbook : AppCompatActivity() {
    lateinit var binding: ActivityDetailKegiatanLogbookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKegiatanLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle : Bundle? = intent.extras
        val tanggal = bundle!!.getString("tanggal")

        binding.tempatDetail.text = tanggal

        val btnaddrespon = findViewById<Button>(R.id.respon)
        btnaddrespon.setOnClickListener{
            Intent(this, IsiRespon::class.java).also {
                startActivity(it)
            }
        }
        val btnbacdetail = findViewById<ImageView>(R.id.backBtn)

        btnbacdetail.setOnClickListener{
            onBackPressed();
        }
    }

}