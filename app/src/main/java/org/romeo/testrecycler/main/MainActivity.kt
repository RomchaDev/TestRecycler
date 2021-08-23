package org.romeo.testrecycler.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import org.romeo.testrecycler.R
import org.romeo.testrecycler.base.list.BaseAdapter
import org.romeo.testrecycler.base.list.BaseListViewModel
import org.romeo.testrecycler.databinding.ActivityMainBinding
import org.romeo.testrecycler.databinding.ItemUserBinding
import org.romeo.testrecycler.entity.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel = ViewModelProvider
        .NewInstanceFactory()
        .create(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = BaseAdapter(
            viewModel.listViewModel,
            R.layout.item_user
        ) { view, viewState ->
            val rvBinding = ItemUserBinding.bind(view)
            rvBinding.firstName.text = viewState.firstName
            rvBinding.lastName.text = viewState.lastName
        }

        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)
    }
}