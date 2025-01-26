package com.hongstudio.flabrecyclerviewassignment

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemNormalBinding

class NormalItemViewHolder(
    private val binding: ItemNormalBinding,
    private val onTrashIconClick: (Item) -> Unit
) : ViewHolder(binding.root) {
    fun bind(item: Item) {
        binding.textViewNormalItem.text = item.title
        binding.imageViewTrashCan.setOnClickListener {
            onTrashIconClick(item)
        }
    }
}