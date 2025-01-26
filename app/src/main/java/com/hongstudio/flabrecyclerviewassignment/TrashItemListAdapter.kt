package com.hongstudio.flabrecyclerviewassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemTrashBinding

class TrashItemListAdapter : ListAdapter<TrashItem, TrashItemViewHolder>(
    object : ItemCallback<TrashItem>() {
        override fun areItemsTheSame(oldItem: TrashItem, newItem: TrashItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: TrashItem, newItem: TrashItem) =
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