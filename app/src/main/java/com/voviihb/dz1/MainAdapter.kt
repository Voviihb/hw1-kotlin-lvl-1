package com.voviihb.dz1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * ListAdapter?
 */
class MainAdapter() : RecyclerView.Adapter<MainViewHolder>() {
    /**
     * В котлине приняты конструкции вроде arrayListOf()
     */
    val items: ArrayList<Int> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val numberTextView: TextView = itemView.findViewById(R.id.numberTextView)

    fun bind(item: Int) {
        val color = if (item % 2 == 0) R.color.red else R.color.blue
        numberTextView.text = item.toString()
        numberTextView.background = ContextCompat.getDrawable(itemView.context, color)
    }

}