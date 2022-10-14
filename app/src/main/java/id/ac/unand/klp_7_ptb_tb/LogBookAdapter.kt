package id.ac.unand.klp_7_ptb_tb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LogBookAdapter(private val logbookList : ArrayList<datalogbook>)
    : RecyclerView.Adapter<LogBookAdapter.LogBookViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogBookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_logbook,parent, false)
        return LogBookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LogBookViewHolder, position: Int) {
        val LogBookList = logbookList[position]
        holder.harilogbook.text = LogBookList.hari
        holder.tanggallogbook.text = LogBookList.tanggal
    }

    override fun getItemCount(): Int {
        return logbookList.size
    }

    class LogBookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val harilogbook :  TextView = itemView.findViewById(R.id.hari_logbook)
        val tanggallogbook : TextView = itemView.findViewById(R.id.tanggal_logbook)

    }
}