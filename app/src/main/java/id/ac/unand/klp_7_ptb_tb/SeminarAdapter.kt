package id.ac.unand.klp_7_ptb_tb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SeminarAdapter(private val seminarlist:ArrayList<daftarseminar>)
    : RecyclerView.Adapter<SeminarAdapter.SeminarViewHolder>(){

    class SeminarViewHolder(itemView: View,):RecyclerView.ViewHolder(itemView){
        val namaMahasiswaSeminar : TextView = itemView.findViewById(R.id.name)
        val nimMahasiswaSeminar : TextView = itemView.findViewById(R.id.agency)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeminarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_seminar, parent, false)
        return SeminarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SeminarViewHolder, position: Int) {
        val SeminarList = seminarlist[position]
        holder.namaMahasiswaSeminar.text = SeminarList.nama_mahasiswa_seminar
        holder.nimMahasiswaSeminar.text = SeminarList.nim_mahasiswa_seminar
    }

    override fun getItemCount(): Int {
        return seminarlist.size
    }
}