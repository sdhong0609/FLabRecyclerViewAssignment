package com.hongstudio.flabrecyclerviewassignment.view

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemNormalBinding
import com.hongstudio.flabrecyclerviewassignment.model.Item

class NormalItemViewHolder(
    private val binding: ItemNormalBinding,
    private val onTrashIconClick: (position: Int) -> Unit
) : ViewHolder(binding.root) {

    init {
        binding.imageViewTrashCan.setOnClickListener {
            onTrashIconClick(absoluteAdapterPosition)
        }
    }

    fun bind(item: Item) {
        binding.textViewNormalItem.text = item.title
    }
}

