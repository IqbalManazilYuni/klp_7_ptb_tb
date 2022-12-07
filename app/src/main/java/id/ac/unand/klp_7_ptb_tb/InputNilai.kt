package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityInputNilaiBinding

class InputNilai : AppCompatActivity() {
    private lateinit var binding: ActivityInputNilaiBinding
    private val CHANNEL_ID = "channel_id"
    private val NOTIFICATION_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputNilaiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btntambah = findViewById<Button>(R.id.btntambah)

        btntambah.setOnClickListener{
            Intent(this, IsiNilaiMahasiswa::class.java).also{
                startActivity(it)
            }
        }
        val btnbacinput = findViewById<ImageView>(R.id.backBtn)

        btnbacinput.setOnClickListener{
            onBackPressed();
        }

        binding.hapusnilai.setOnClickListener {
            showNotification()
        }
    }

    private fun showNotification(){
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("BERHASIL MENGHAPUS")
            .setContentText("Anda berhasil menghapus nilai")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val mChannelName = "Channel Name"
            val mChannelDescription = "uhuy"
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
