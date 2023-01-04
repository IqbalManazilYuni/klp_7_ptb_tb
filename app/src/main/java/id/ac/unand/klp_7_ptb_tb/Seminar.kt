package id.ac.unand.klp_7_ptb_tb

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.Network.KpClient
import id.ac.unand.klp_7_ptb_tb.Network.NetworkConfig
import id.ac.unand.klp_7_ptb_tb.databinding.ActivitySeminarBinding
import id.ac.unand.klp_7_ptb_tb.models.SeminarInItem
import id.ac.unand.klp_7_ptb_tb.models.SeminarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

        val SeminarAdapter = SeminarAdapter(seminarList)

        val sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("token",null)

        val seminarInItem =ArrayList<SeminarInItem>()

        recyclerView =binding.recyleView3


        val client: KpClient = NetworkConfig().getService()
        val call: Call<SeminarResponse> = client.getDetailSeminar("Bearer "+token)

        call.enqueue(object : Callback<SeminarResponse> {
            override fun onResponse(call: Call<SeminarResponse>, response: Response<SeminarResponse>) {

                val respon: SeminarResponse? = response.body()
                if (respon!= null){
                    val list : List<SeminarInItem> = respon.internships as List<SeminarInItem>
                }


                Log.d("anjay", response.toString())
            }

            override fun onFailure(call: Call<SeminarResponse>, t: Throwable) {
                Toast.makeText(this@Seminar, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        val btnbacrp = binding.backBtn

        btnbacrp.setOnClickListener{
            onBackPressed();
        }




    }
}