package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class UpdateProfile : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

        val btnbacup = findViewById<ImageView>(R.id.backBtn)

        btnbacup.setOnClickListener{
            onBackPressed();
        }
        val btnUpdate = findViewById<Button>(R.id.updateBtn)

        btnUpdate.setOnClickListener{
            Intent(this, DashboardKp::class.java).also{
                startActivity(it)
            }
        }
        val btncancel = findViewById<Button>(R.id.cancelBtn)

        btncancel.setOnClickListener{
            Intent(this, ProfileDosen::class.java).also{
                startActivity(it)
            }
        }
    }
}