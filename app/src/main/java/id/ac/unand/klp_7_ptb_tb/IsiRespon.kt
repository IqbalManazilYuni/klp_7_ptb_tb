package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class IsiRespon : AppCompatActivity() {
    private var CHANNEL_ID = "1"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_respon)

        val btnbacinpurespon = findViewById<ImageView>(R.id.backBtn)

        btnbacinpurespon.setOnClickListener{
            onBackPressed();
        }

        val btntambahrespon = findViewById<Button>(R.id.tambahrespon)
        btntambahrespon.setOnClickListener{
            Intent(this,IsiRespon::class.java).also {
                createNotificationChannel()
                startActivity(it)
            }
        }
    }
    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Isi Respon"
            val descriptionText = "Notifikasi Dosen Mengisi Respon"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, IsiRespon::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_done_all_24)
            .setContentTitle("Respon Terkirim")
            .setContentText("Respon Anda Berhasil Terkirim")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            // Set the intent that will fire when the user taps the notification
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            val notificationId = 1
            notify(notificationId, builder.build())
        }
    }

}