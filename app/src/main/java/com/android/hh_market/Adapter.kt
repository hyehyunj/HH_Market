package com.android.hh_market

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.hh_market.databinding.ItemRecyclerviewBinding

class Adapter(private val item: MutableList<ProductInfo>) : RecyclerView.Adapter<Adapter.Holder>() {
    companion object {
        private const val TAG = "Adapter" }

    interface ItemClick {
        fun onClick(view : View, position : Int)

    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {


        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        holder.image.setImageResource(item[position].image)
        holder.title.setText(item[position].title)
        holder.location.setText(item[position].location)
        holder.price.setText(item[position].price)
        holder.chat.text = item[position].chat.toString()
        holder.like.text = item[position].like.toString()

    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class Holder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.ivItemTitle
        val title = binding.tvItemTitle
        val location = binding.tvItemLocation
        val price = binding.tvItemPrice
        val chat = binding.tvItemChat
        val like = binding.tvItemLike
    }


}