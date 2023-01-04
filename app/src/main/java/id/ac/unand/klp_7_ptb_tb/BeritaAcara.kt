package id.ac.unand.klp_7_ptb_tb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityBeritaAcaraBinding
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDetailSeminarBinding

class BeritaAcara : AppCompatActivity() {

    lateinit var binding: ActivityBeritaAcaraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita_acara)
        binding = ActivityBeritaAcaraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnbacrp = binding.backBtn

        btnbacrp.setOnClickListener{
            onBackPressed();
        }
    }
}