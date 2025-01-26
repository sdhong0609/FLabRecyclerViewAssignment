package com.hongstudio.flabrecyclerviewassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemNormalBinding

class NormalItemListAdapter : ListAdapter<NormalItem, NormalItemViewHolder>(
    object : ItemCallback<NormalItem>() {
        override fun areItemsTheSame(oldItem: NormalItem, newItem: NormalItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: NormalItem, newItem: NormalItem) =
            oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NormalItemViewHolder {
        return NormalItemViewHolder(
            ItemNormalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NormalItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}