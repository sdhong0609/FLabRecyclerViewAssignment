package com.hongstudio.flabrecyclerviewassignment

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemTrashBinding

class TrashItemViewHolder(private val binding: ItemTrashBinding) : ViewHolder(binding.root) {
    fun bind(trashItem: TrashItem) {
        binding.textViewTrashItem.text = trashItem.title
        binding.textViewTimeout.run {
            text = context.getString(R.string.trash_items_timeout_second, trashItem.timeoutSecond)
        }
    }
}