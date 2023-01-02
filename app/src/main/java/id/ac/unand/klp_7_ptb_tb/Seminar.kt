package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.databinding.ActivitySeminarBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Seminar : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var seminarList : ArrayList<daftarseminar>
    private lateinit var seminarAdapter: SeminarAdapter
    lateinit var binding: ActivitySeminarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeminarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //dimulai
        recyclerView = findViewById(R.id.recyle_view_3)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        seminarList = ArrayList()

        seminarList.add(daftarseminar("Iqbal Manazil Yuni", "201152xxxx"))

        seminarAdapter = SeminarAdapter(seminarList)
        recyclerView.adapter = seminarAdapter


    }
}