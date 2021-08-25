package org.romeo.testrecycler.main

import android.os.Handler
import androidx.lifecycle.ViewModel
import org.romeo.testrecycler.base.list_1.BaseListViewModel
import org.romeo.testrecycler.entity.User


//Is not in use
class MainViewModel : ViewModel() {
/*    val listViewModel = BaseListViewModel(itemsFirst())
    private val handler = Handler()

    init {
        handler.postDelayed({
            listViewModel.items = itemsSecond()
        }, 5000)
    }*/

    // Request to repository
    fun itemsFirst(): List<User> {
        val list = mutableListOf<User>()

        repeat(100) { i ->
            list.add(User("firstName$i", "lastName$i"))
        }

        return list
    }

    // One more request
    fun itemsSecond(): List<User> {
        val list = mutableListOf<User>()

        repeat(100) { i ->
            list.add(User("Hello$i", "World !!!$i"))
        }

        return list
    }
}