package com.example.addtocart_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val  context: Context, private val itemList: List<Model>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: Model)
    }

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.title.text = currentItem.title
        holder.subTitle.text = currentItem.subtitle
        holder.image.setImageResource(currentItem.imageResId)

        holder.plus.setOnClickListener{
            Toast.makeText(context, "plus clicked" , Toast.LENGTH_LONG).show()
        }
        holder.minus.setOnClickListener{
            Toast.makeText(context, "minus clicked" , Toast.LENGTH_LONG).show()
        }

        // Set a click listener on the item view
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleTextView)
        val subTitle: TextView = itemView.findViewById(R.id.subtitleTextView)
        val image: ImageView = itemView.findViewById(R.id.imageView)
        val plus: TextView = itemView.findViewById(R.id.plus)
        val minus: TextView = itemView.findViewById(R.id.minus)
        val btn: TextView = itemView.findViewById(R.id.btn)
    }
}


