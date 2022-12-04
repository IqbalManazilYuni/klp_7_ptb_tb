package id.ac.unand.klp_7_ptb_tb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SeminarAdapter(private val hadirList:ArrayList<Hadir>) : RecyclerView.Adapter<SeminarAdapter.HadirViewHolder>(){

//    private lateinit var mahasiswaListener : onItemClickListener
//
//    interface onItemClickListener{
//        fun onItemClick(position: Int)
//    }
//
//    fun setOnItemClickListerner(listener:onItemClickListener){
//        mahasiswaListener = listener
//    }

    //nampilin data sesuai dengan bagian layout


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadirViewHolder {

        val imageView =LayoutInflater.from(parent.context).inflate(R.layout.item_seminar,
        parent,false)
        return HadirViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: HadirViewHolder, position: Int) {

        val currentItem = hadirList[position]
        holder.imgview.setImageResource(currentItem.imgview)
        holder.namaMahasiswa.text = currentItem.nama_mahasiswa
        holder.nimMahasiswa.text = currentItem.nim_mahasiswa
    }

    override fun getItemCount(): Int {
        return hadirList.size
    }

    class HadirViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imgview : ImageView = itemView.findViewById(R.id.gambar_mahasiswa_item)
        val namaMahasiswa : TextView = itemView.findViewById(R.id.nama_mahasiswa_item)
        val nimMahasiswa : TextView = itemView.findViewById(R.id.nim_mahasiswa_item)

//        init{
//            itemView.setOnClickListener{
//                listener.onItemClick(absoluteAdapterPosition)
//            }
//        }
    }

}