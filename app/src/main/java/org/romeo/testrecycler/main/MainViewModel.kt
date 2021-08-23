package org.romeo.testrecycler.main

import android.os.Handler
import androidx.lifecycle.ViewModel
import org.romeo.testrecycler.base.list.BaseListViewModel
import org.romeo.testrecycler.entity.User

class MainViewModel : ViewModel() {
    val listViewModel = BaseListViewModel(itemsFirst())
    private val handler = Handler()

    init {
        handler.postDelayed({
            listViewModel.items = itemsSecond()
        }, 5000)
    }

    // Request to repository
    private fun itemsFirst(): List<User> {
        val list = mutableListOf<User>()

        repeat(100) { i ->
            list.add(User("firstName$i", "lastName$i"))
        }

        return list
    }

    // One more request
    private fun itemsSecond(): List<User> {
        val list = mutableListOf<User>()

        repeat(100) { i ->
            list.add(User("Hello$i", "World !!!$i"))
        }

        return list
    }
}