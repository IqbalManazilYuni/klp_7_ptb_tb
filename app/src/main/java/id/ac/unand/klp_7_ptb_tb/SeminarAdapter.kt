package id.ac.unand.klp_7_ptb_tb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.unand.klp_7_ptb_tb.databinding.ItemSeminarBinding
import id.ac.unand.klp_7_ptb_tb.models.SeminarInItem

class SeminarAdapter()
    : RecyclerView.Adapter<SeminarAdapter.SeminarViewHolder>(){

    private lateinit var seminarListener: SeminarAdapter.onItemClicklistener
    interface onItemClicklistener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener : onItemClicklistener){
        seminarListener = listener
    }

    var seminarlist : List<SeminarInItem> = ArrayList()

    fun setseminarList(seminarList: List<SeminarInItem>){
        this.seminarlist = seminarlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeminarViewHolder {
        return SeminarViewHolder(ItemSeminarBinding.inflate(LayoutInflater.from(parent.context), parent, false), seminarListener)
    }

    override fun onBindViewHolder(holder: SeminarViewHolder, position: Int) {
        val item : SeminarInItem = seminarlist.get(position)
        holder.itemBinding.name.text = item.name
        holder.itemBinding.nim.text = item.nim
    }

    override fun getItemCount(): Int {
        return seminarlist.size
    }

    inner class SeminarViewHolder(val itemBinding : ItemSeminarBinding,listener :
    onItemClicklistener):
            RecyclerView.ViewHolder(itemBinding.root){
                init {
                    itemView.setOnClickListener{
                        listener.onItemClick(bindingAdapterPosition)
                    }
                }
            }

}