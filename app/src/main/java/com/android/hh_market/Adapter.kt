package com.android.hh_market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.hh_market.databinding.ItemRecyclerviewBinding

class Adapter(private val item: MutableList<ProductInfo>) : RecyclerView.Adapter<Adapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.Holder, position: Int) {
        holder.image.setImageResource(item[position].image)
        holder.title.setText(item[position].title)
        holder.location.setText(item[position].location)
        holder.price.setText(item[position].price)
//        holder.chat.setText(item[position].chat)
//        holder.adress.setText(item[position].adress)

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
//        val chat = _binding.tvItemChat
//        val like = _binding.tvItemLike
    }


}