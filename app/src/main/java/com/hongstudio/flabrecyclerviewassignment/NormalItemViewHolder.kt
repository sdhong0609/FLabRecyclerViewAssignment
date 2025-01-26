package com.hongstudio.flabrecyclerviewassignment

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemNormalBinding

class NormalItemViewHolder(private val binding: ItemNormalBinding) : ViewHolder(binding.root) {
    fun bind(normalItem: NormalItem) {
        binding.textViewNormalItem.text = normalItem.title
    }
}