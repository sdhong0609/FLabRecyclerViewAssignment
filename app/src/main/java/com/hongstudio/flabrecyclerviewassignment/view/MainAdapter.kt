package com.hongstudio.flabrecyclerviewassignment.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.hongstudio.flabrecyclerviewassignment.base.BaseViewHolder
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemNormalBinding
import com.hongstudio.flabrecyclerviewassignment.databinding.ItemTrashBinding
import com.hongstudio.flabrecyclerviewassignment.model.Item

class MainAdapter(
    private val onTrashIconClick: (position: Int) -> Unit,
    private val onTrashItemClick: (position: Int) -> Unit
) : ListAdapter<Item, BaseViewHolder<ViewBinding, Item>>(
    object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem
    }
) {
    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Item.Normal -> TYPE_NORMAL
            is Item.Trash -> TYPE_TRASH
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ViewBinding, Item> {
        return when (viewType) {
            TYPE_NORMAL -> NormalItemViewHolder(
                ItemNormalBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onTrashIconClick
            ) as BaseViewHolder<ViewBinding, Item>

            else -> TrashItemViewHolder(
                ItemTrashBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onTrashItemClick
            ) as BaseViewHolder<ViewBinding, Item>
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding, Item>, position: Int) {
        holder.bind(getItem(position))
    }


    companion object {
        private const val TYPE_NORMAL = 1_000
        private const val TYPE_TRASH = 2_000
    }
}