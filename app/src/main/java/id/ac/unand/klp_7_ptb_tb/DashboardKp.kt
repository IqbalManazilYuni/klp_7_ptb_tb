package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityDashboardKpBinding
import id.ac.unand.klp_7_ptb_tb.databinding.ActivityHalamanLoginAppBinding
import id.ac.unand.klp_7_ptb_tb.models.ListMahasiswa
import id.ac.unand.klp_7_ptb_tb.models.MahasiswaResponse
import id.ac.unand.tb_klp_7.MahasiswaAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardKp : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mahasiswaList : ArrayList<mahasiswa>
    private lateinit var mahasiswaAdapter: MahasiswaAdapter

    lateinit var binding: ActivityDashboardKpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardKpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter:MahasiswaAdapter= MahasiswaAdapter()

        val sharedPrefToken = getSharedPreferences("sharedpref", MODE_PRIVATE)?:return
        val token = sharedPrefToken.getString("token",null)
        val sharedPref = getSharedPreferences("mahapref", MODE_PRIVATE)?:return
        val id = sharedPref.getInt("id",5)

        val data = ArrayList<ListMahasiswa>()
        recyclerView = findViewById(R.id.recycler_view)

        Log.d("list-book-debug",token.toString())
        val client: KpClient = NetworkConfig().getService()
        val call: Call<MahasiswaResponse> = KpClient.getMahasiswa(token = "Bearer " + token, id)

    }
}