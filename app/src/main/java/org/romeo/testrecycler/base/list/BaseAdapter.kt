package org.romeo.testrecycler.base.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView


class BaseAdapter<T>(
    private val viewModel: BaseListViewModel<T>,
    private val itemViewId: Int,
    private val bind: ((View, viewState: T) -> Unit)? = null
) : RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder>() {

    inner class BaseViewHolder(
        private val root: View
    ) : RecyclerView.ViewHolder(root) {
        val viewModel = BaseItemViewModel<T>()

        init {
            viewModel
                .getLiveData()
                .observe(root.context as LifecycleOwner) { viewState ->
                    bind?.invoke(root, viewState)
                }
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        val context = recyclerView.context
        // List may be useful later
        viewModel.getLiveData().observe(context as LifecycleOwner) { list ->
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(itemViewId, parent, false)

        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        viewModel.bind(holder.viewModel, position)
    }

    override fun getItemCount() = viewModel.itemCount
}