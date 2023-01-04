package id.ac.unand.tb_klp_7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.R
import id.ac.unand.klp_7_ptb_tb.databinding.ItemMahasiswaBinding
import id.ac.unand.klp_7_ptb_tb.models.ListMahasiswa

class MahasiswaAdapter()
    : RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>(){

    var listMahasiswa : List<ListMahasiswa> = ArrayList()
    fun setlistLogbook(listMahasiswa:List<ListMahasiswa>){
        this.listMahasiswa = listMahasiswa
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        return  MahasiswaViewHolder(ItemMahasiswaBinding.inflate(LayoutInflater.from(parent.context)
            , parent, false))
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
    inner class MahasiswaViewHolder(val itemBinding:ItemMahasiswaBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
    }
}



