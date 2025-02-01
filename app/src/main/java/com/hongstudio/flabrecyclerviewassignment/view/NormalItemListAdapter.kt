package com.hongstudio.flabrecyclerviewassignment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemNormalBinding
import com.hongstudio.flabrecyclerviewassignment.model.Item

class NormalItemListAdapter(
    private val onTrashIconClick: (Item) -> Unit
) : ListAdapter<Item, NormalItemViewHolder>(
    object : ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item) =
            oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NormalItemViewHolder {
        return NormalItemViewHolder(
            ItemNormalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onTrashIconClick
        )
    }

    override fun onBindViewHolder(holder: NormalItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}