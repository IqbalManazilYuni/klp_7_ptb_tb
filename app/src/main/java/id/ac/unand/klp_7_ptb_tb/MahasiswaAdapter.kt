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

    private lateinit var mahasiswaListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListerner(listener:onItemClickListener){
        mahasiswaListener = listener
    }

    //nampilin data sesuai dengan bagian layout
    class MahasiswaViewHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val imageview : ImageView = itemView.findViewById(R.id.gambar_mahasiswa_item)
        val namaMahasiswa : TextView = itemView.findViewById(R.id.name)
        val nimMahasiswa : TextView = itemView.findViewById(R.id.nim_mahasiswa_item)
        val lokasiMahasiswa : TextView = itemView.findViewById(R.id.nim)
        init{
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa, parent, false)
        return MahasiswaViewHolder(view, mahasiswaListener)
    }
    //mengambil data dari class data dan menyimpan di variabel yang di deklarasikan di methode MahasiswaViewHolder
    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val Mahasiswa = mahasiswaList[position]
        holder.imageview.setImageResource(Mahasiswa.imgview)
        holder.namaMahasiswa.text = Mahasiswa.nama_mahasiswa
        holder.nimMahasiswa.text = Mahasiswa.nim_mahasiswa
        holder.lokasiMahasiswa.text = Mahasiswa.lokasi_kp
    }
    //menghitung jumlah data
    override fun getItemCount(): Int {
        return mahasiswaList.size
    }
}