package id.ac.unand.tb_klp_7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.R
import id.ac.unand.klp_7_ptb_tb.mahasiswa

class MahasiswaAdapter(private val mahasiswaList:ArrayList<mahasiswa>)
    : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>(){

    var onItemClick : ((mahasiswa)-> Unit)? = null

    class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageview : ImageView = itemView.findViewById(R.id.gambar_mahasiswa_item)
        val namaMahasiswa : TextView = itemView.findViewById(R.id.nama_mahasiswa_item)
        val nimMahasiswa : TextView = itemView.findViewById(R.id.nim_mahasiswa_item)
        val lokasiMahasiswa : TextView = itemView.findViewById(R.id.lokasi_mahasiswa_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val Mahasiswa = mahasiswaList[position]
        holder.imageview.setImageResource(Mahasiswa.imgview)
        holder.namaMahasiswa.text = Mahasiswa.nama_mahasiswa
        holder.nimMahasiswa.text = Mahasiswa.nim_mahasiswa
        holder.lokasiMahasiswa.text = Mahasiswa.lokasi_kp

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(Mahasiswa)
        }
    }

    override fun getItemCount(): Int {
        return mahasiswaList.size
    }
}