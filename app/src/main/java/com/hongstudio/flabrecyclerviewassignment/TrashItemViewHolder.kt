package com.hongstudio.flabrecyclerviewassignment

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemTrashBinding

class TrashItemViewHolder(
    private val binding: ItemTrashBinding,
    private val onTrashItemClick: (Item) -> Unit
) : ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.textViewTrashItem.text = item.title
        binding.textViewTimeout.run {
            text = context.getString(R.string.trash_items_timeout_second, item.timeoutSecond)
        }
        binding.root.setOnClickListener {
            onTrashItemClick(item)
        }
    }
}