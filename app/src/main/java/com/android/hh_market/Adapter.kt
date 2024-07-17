package com.android.hh_market

import android.icu.text.DecimalFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.hh_market.databinding.ItemRecyclerviewBinding

class Adapter(
    private val item: MutableList<ProductInfo>,
    private val itemClickListener: (item: ProductInfo, position: Int) -> Unit,
    private val itemLongClickListener: (item: ProductInfo, position: Int) -> Boolean
) : RecyclerView.Adapter<Adapter.Holder>() {
    companion object {
        private const val TAG = "Adapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        val binding =
            ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class Holder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val dec = DecimalFormat("#,###원")
        fun bind(item: ProductInfo) {
            binding.apply {
                ivItemTitle.setImageResource(item.image)
                tvItemTitle.text = item.title
                tvItemLocation.text = item.location
                tvItemPrice.text = dec.format(item.price)
                tvItemChat.text = item.chat.toString()
                tvItemLike.text = item.like.toString()
                itemRecyclerview.setOnClickListener {
                    itemClickListener(item, adapterPosition)
                }
                itemRecyclerview.setOnLongClickListener {
                    itemLongClickListener(item, adapterPosition)
                }


            }
        }


    }
}