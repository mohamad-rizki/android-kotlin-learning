package com.github.android.kotlinacademy

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_item.view.*

class ItemAdapter (private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
        ItemHolder(LayoutInflater.from(context).inflate(R.layout.row_item, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem (item: Item, listener: (Item) -> Unit) {
            itemView.name.text = item.name
            item.image?.let { Picasso.get().load(it).into(itemView.image) }
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }
}