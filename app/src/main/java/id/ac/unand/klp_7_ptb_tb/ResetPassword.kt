package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityResetPasswordBinding

class ResetPassword : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        val btnbacrp = findViewById<ImageView>(R.id.backBtn)

        btnbacrp.setOnClickListener{
            onBackPressed();
        }
        val btnReset = findViewById<Button>(R.id.resetPassword)

        btnReset.setOnClickListener{
            Intent(this,HalamanLoginApp::class.java).also {
                startActivity(it)
            }
        }
        val btnBtlReset = findViewById<Button>(R.id.resetcancel)

        btnBtlReset.setOnClickListener{
            Intent(this,ProfileDosen::class.java).also {
                startActivity(it)
            }
        }
    }
}