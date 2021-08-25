package org.romeo.testrecycler.base.list_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter<T : ListItem>(
    private val itemLayoutId: Int,
    private val bind: ((View, data: T) -> Unit)? = null,
) : ListAdapter<T, BaseAdapter<T>.BaseViewHolder>(BaseDiffUtilCallback<T>()) {

    inner class BaseViewHolder(
        private val root: View
    ) : RecyclerView.ViewHolder(root) {
        fun bind(data: T) = bind?.let { it(root, data) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(itemLayoutId, parent, false)

        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}