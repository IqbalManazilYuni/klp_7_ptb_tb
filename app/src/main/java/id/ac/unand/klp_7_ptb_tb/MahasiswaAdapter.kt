package id.ac.unand.tb_klp_7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.databinding.ItemMahasiswaBinding
import id.ac.unand.klp_7_ptb_tb.models.ListMahasiswa

class MahasiswaAdapter()
    : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>(){

    private lateinit var mahasiswaListener : MahasiswaAdapter.OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mahasiswaListener = listener
    }

    var listMahasiswa : List<ListMahasiswa> = ArrayList()

    fun setlistMahasiswa(listMahasiswa:List<ListMahasiswa>){
        this.listMahasiswa = listMahasiswa
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        return  MahasiswaViewHolder(ItemMahasiswaBinding.inflate(LayoutInflater.from(parent.context)
            , parent,false),mahasiswaListener)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val item : ListMahasiswa = listMahasiswa.get(position)
        holder.itemBinding.name.text = item.name
        holder.itemBinding.nim.text = item.nim
        holder.itemBinding.agency.text = item.agency
    }
    override fun getItemCount(): Int {
        return listMahasiswa.size
    }
    inner class MahasiswaViewHolder(val itemBinding:ItemMahasiswaBinding, listener: OnItemClickListener):
        RecyclerView.ViewHolder(itemBinding.root) {
            init {
                itemView.setOnClickListener {
                    listener.onItemClick(bindingAdapterPosition)
                }
            }
    }
}



