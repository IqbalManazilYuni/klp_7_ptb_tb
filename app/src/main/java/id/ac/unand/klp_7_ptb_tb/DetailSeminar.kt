package id.ac.unand.klp_7_ptb_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDetailSeminarBinding

class DetailSeminar : AppCompatActivity() {
    lateinit var binding: ActivityDetailSeminarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSeminarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val bundle : Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val nim = bundle.getString("nim")
        val agency = bundle.getString("agency")
        val supervisor = bundle.getString("supervisor")
        val start_at = bundle.getString("start_at")
        val end_at = bundle.getString("end_at")
        val title = bundle.getString("title")

        binding.name.text = name
        binding.nim.text = nim
        binding.agency.text = agency
        binding.supervisor.text = supervisor
        binding.startAt.text = start_at
        binding.endAt.text = end_at
        binding.title.text = title*/

        val btnbacinput = findViewById<ImageView>(R.id.backBtn)

        btnbacinput.setOnClickListener{
            onBackPressed();
        }


        val detail_seminar_btn = binding.detailSeminarBtn
        detail_seminar_btn.setOnClickListener{
            val intent = Intent (this,Seminar::class.java)
            startActivity(intent)
        }

        val berita_acara_btn = binding.beritaAcaraBtn
        berita_acara_btn.setOnClickListener{
            val intent = Intent (this,BeritaAcara::class.java)
                startActivity(intent)
        }
    }
}
