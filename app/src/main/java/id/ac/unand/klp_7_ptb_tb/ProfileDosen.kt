package id.ac.unand.klp_7_ptb_tb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ProfileDosen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_dosen)

        val btnbacpd = findViewById<ImageView>(R.id.backBtn)

        btnbacpd.setOnClickListener{
            onBackPressed();
        }
        val btnResetPassword = findViewById<Button>(R.id.btnresetpass)

        btnResetPassword.setOnClickListener{
            Intent(this, UpdateProfile::class.java).also {
                startActivity(it)
            }
        }
        val btnupdate = findViewById<Button>(R.id.btnUpdateDosen)

        btnupdate.setOnClickListener{
            Intent(this, ResetPassword::class.java).also{
                startActivity(it)
            }
        }
    }
}