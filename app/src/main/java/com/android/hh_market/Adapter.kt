package com.android.hh_market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.hh_market.databinding.ItemRecyclerviewBinding

class Adapter(val item : MutableList<ProductInfo>) : RecyclerView.Adapter<Adapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        val _binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(_binding)
    }

    override fun onBindViewHolder(holder: Adapter.Holder, position: Int) {
        holder.image.setImageResource(item[position].image)
        holder.title.setText(item[position].title)
        holder.adress.setText(item[position].adress)
        holder.price.setText(item[position].price)
//        holder.chat.setText(item[position].chat)
//        holder.adress.setText(item[position].adress)

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class Holder(val _binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(_binding.root) {
        val image = _binding.ivItemTitle
        val title = _binding.tvItemTitle
        val adress = _binding.tvItemAdress
        val price = _binding.tvItemPrice
//        val chat = _binding.tvItemChat
//        val like = _binding.tvItemLike
    }


}