package com.hongstudio.flabrecyclerviewassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemTrashBinding

class TrashItemListAdapter : ListAdapter<Item, TrashItemViewHolder>(
    object : ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item) =
            oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrashItemViewHolder {
        return TrashItemViewHolder(
            ItemTrashBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TrashItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}