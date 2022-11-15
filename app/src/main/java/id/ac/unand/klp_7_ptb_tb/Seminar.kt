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
import java.text.SimpleDateFormat
import java.util.*

class Seminar : AppCompatActivity() {

    private lateinit var tvDatePicker: TextView
    private lateinit var btnDatePicker: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seminar)
        val accept = findViewById<Button>(R.id.acc_date)
        accept.setOnClickListener{
            Intent(this,DetailMahasiswa::class.java).also {
                startActivity(it)
            }
        }
        val btnbacseminar = findViewById<ImageView>(R.id.backBtn)

        btnbacseminar.setOnClickListener{
            onBackPressed();
        }
        tvDatePicker = findViewById(R.id.dateseminar)
        btnDatePicker = findViewById(R.id.datebtn)

        val mycalender = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
            mycalender.set(Calendar.YEAR,year)
            mycalender.set(Calendar.MONTH,month)
            mycalender.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLable(mycalender)
        }
        btnDatePicker.setOnClickListener{
            DatePickerDialog(this,datePicker, mycalender.get(Calendar.YEAR),
            mycalender.get(Calendar.MONTH),
            mycalender.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
    private fun updateLable(mycalender : Calendar){
        val myformat = "dd-MM-YYYY"
        val sdf = SimpleDateFormat(myformat,Locale.UK)
        tvDatePicker.setText(sdf.format(mycalender.time))
    }
}