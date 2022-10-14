package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HalamanLoginApp : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_login_app)

        val btnlogin = findViewById<Button>(R.id.btnlogin)

        btnlogin.setOnClickListener{
            Intent(this, DashboardKp::class.java).also{
                startActivity(it)
                finish()
            }
        }
    }
}