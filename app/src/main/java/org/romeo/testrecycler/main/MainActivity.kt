package org.romeo.testrecycler.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.romeo.testrecycler.R
import org.romeo.testrecycler.base.list_2.BaseAdapter
import org.romeo.testrecycler.databinding.ActivityMainBinding
import org.romeo.testrecycler.databinding.ItemUserBinding
import org.romeo.testrecycler.entity.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Uses adapter from list_2 package
        val adapter = BaseAdapter<User>(
            R.layout.item_user
        ) { view, data ->
            val rvBinding = ItemUserBinding.bind(view)
            rvBinding.firstName.text = data.firstName
            rvBinding.lastName.text = data.lastName
        }


        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        adapter.submitList(itemsFirst())
    }

    fun itemsFirst(): List<User> {
        val list = mutableListOf<User>()

        repeat(100) { i ->
            list.add(User("firstName$i", "lastName$i"))
        }

        return list
    }
}