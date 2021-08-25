package org.romeo.testrecycler.base.list_2

import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtilCallback<T : ListItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) =
        newItem.areItemsTheSame(oldItem)

    override fun areContentsTheSame(oldItem: T, newItem: T) =
        newItem.areContentsTheSame(oldItem)
}