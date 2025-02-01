package com.hongstudio.flabrecyclerviewassignment.view

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hongstudio.flabrecyclerviewassignment.R
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemTrashBinding
import com.hongstudio.flabrecyclerviewassignment.model.Item

class TrashItemViewHolder(
    private val binding: ItemTrashBinding,
    private val onTrashItemClick: (Item) -> Unit
) : ViewHolder(binding.root) {

    fun bind(item: Item, timeoutSecond: Int) {
        binding.textViewTrashItem.text = item.title
        binding.textViewTimeout.run {
            text = context.getString(R.string.trash_items_timeout_second, timeoutSecond)
        }
        binding.root.setOnClickListener {
            onTrashItemClick(item)
        }
    }
}