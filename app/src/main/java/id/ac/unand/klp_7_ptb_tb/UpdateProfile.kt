package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityInputNilaiBinding
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityUpdateProfileBinding

class UpdateProfile : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateProfileBinding
    private val CHANNEL_ID = "channel_id"
    private val NOTIFICATION_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnbacinput = findViewById<ImageView>(R.id.backBtn)

        btnbacinput.setOnClickListener{
            onBackPressed();
        }

        binding.updateBtn.setOnClickListener {
            showNotification()
        }
    }

    private fun showNotification(){
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("BERHASIL UPDATE")
            .setContentText("Anda berhasil update data")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val mChannelName = "Channel Name"
            val mChannelDescription = "yeay"
            val mChannelImportance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(CHANNEL_ID, mChannelName,mChannelImportance).apply {
                description = mChannelDescription
            }

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel)
        }

        with(NotificationManagerCompat.from(this)){
            notify(NOTIFICATION_ID, builder.build())
        }
    }
}