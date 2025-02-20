package com.hongstudio.flabrecyclerviewassignment.view

import com.hongstudio.flabrecyclerviewassignment.base.BaseViewHolder
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemNormalBinding
import com.hongstudio.flabrecyclerviewassignment.model.Item

class NormalItemViewHolder(
    private val binding: ItemNormalBinding,
    private val onTrashIconClick: (position: Int) -> Unit
) : BaseViewHolder<ItemNormalBinding, Item>(binding) {

    init {
        binding.imageViewTrashCan.setOnClickListener {
            onTrashIconClick(absoluteAdapterPosition)
        }
    }

    override fun bind(item: Item) {
        binding.textViewNormalItem.text = item.title
    }
}

