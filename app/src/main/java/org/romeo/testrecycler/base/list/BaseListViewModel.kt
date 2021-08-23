package org.romeo.testrecycler.base.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class BaseListViewModel<T>(
    items: List<T>
) {
    var items = items
        set(value) {
            field = value
            liveData.value = value
        }

    private val liveData = MutableLiveData(items)

    val itemCount get() = items.size

    fun bind(viewModel: BaseItemViewModel<T>, pos: Int) {
        viewModel.item = items[pos]
    }

    fun getLiveData() = liveData as LiveData<List<T>>
}