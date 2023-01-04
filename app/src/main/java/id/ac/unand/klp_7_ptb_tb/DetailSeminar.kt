package id.ac.unand.klp_7_ptb_tb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDetailSeminarBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailSeminar : AppCompatActivity() {
    lateinit var binding: ActivityDetailSeminarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSeminarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnbacrp = binding.backBtn

        btnbacrp.setOnClickListener{
            onBackPressed();
        }

        val detail_seminar_btn = findViewById<Button>(R.id.detail_seminar_btn)

        detail_seminar_btn.setOnClickListener{
            Intent(this,Seminar::class.java).also {
                startActivity(it)
            }
        }

        val berita_acara_btn = findViewById<Button>(R.id.berita_acara_btn)

        berita_acara_btn.setOnClickListener{
            Intent(this,BeritaAcara::class.java).also {
                startActivity(it)
            }
        }

        }
}
