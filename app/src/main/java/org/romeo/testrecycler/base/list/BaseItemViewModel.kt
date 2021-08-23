package org.romeo.testrecycler.base.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class BaseItemViewModel<T>(
    item: T? = null
) {
    private val liveData = MutableLiveData<T>()

    var item = item
        set(value) {
            field = value
            liveData.value = item
        }

    fun getLiveData() = liveData as LiveData<T>
}