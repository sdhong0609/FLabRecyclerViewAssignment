package com.hongstudio.flabrecyclerviewassignment.view

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hongstudio.flabrecyclerviewassignment.R
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemTrashBinding
import com.hongstudio.flabrecyclerviewassignment.model.Item

class TrashItemViewHolder(
    private val binding: ItemTrashBinding,
    private val onTrashItemClick: (position: Int) -> Unit
) : ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            onTrashItemClick(absoluteAdapterPosition)
        }
    }

    fun bind(item: Item) {
        binding.textViewTrashItem.text = item.title
        if (item is Item.Trash) {
            binding.textViewTimeout.run {
                text = context.getString(R.string.trash_items_timeout_second, item.timeoutSecond)
            }
        }
    }
}