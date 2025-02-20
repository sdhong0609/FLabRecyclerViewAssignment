package com.hongstudio.flabrecyclerviewassignment.base

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<VB: ViewBinding, ITEM>(
    binding: VB
): ViewHolder(binding.root) {

    abstract fun bind(item: ITEM)
}