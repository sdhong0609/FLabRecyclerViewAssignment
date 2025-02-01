package com.hongstudio.flabrecyclerviewassignment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import com.hongstudio.flabrecyclerviewassignment.common.TimeoutSecond
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemTrashBinding
import com.hongstudio.flabrecyclerviewassignment.model.Item

class TrashItemListAdapter(
    private val onTrashItemClick: (Item) -> Unit
) : ListAdapter<Item, TrashItemViewHolder>(
    object : ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item) =
            oldItem == newItem
    }
) {
    private var timeoutSecond: Int = TimeoutSecond.INITIAL_TIMEOUT_SECOND

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrashItemViewHolder {
        return TrashItemViewHolder(
            ItemTrashBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onTrashItemClick
        )
    }

    override fun onBindViewHolder(holder: TrashItemViewHolder, position: Int) {
        holder.bind(getItem(position), timeoutSecond)
    }

    fun updateTimeout(timeoutSecond: Int) {
        this.timeoutSecond = timeoutSecond
        notifyItemRangeChanged(0, itemCount)
    }
}