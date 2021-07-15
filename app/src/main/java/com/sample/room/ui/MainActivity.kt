package com.sample.room.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.room.ViewModelFactory
import com.sample.room.data.model.User
import com.sample.room.databinding.ActivityMainBinding
import com.sample.room.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var mAdapter: UsersAdapter
    private var list: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClick()
        setupViewModel()
        readAllData()
    }

    private fun setOnClick() {
        binding.read.setOnClickListener {
            readAllData()
        }

        binding.add.setOnClickListener {
            viewModel.addUser(User(0, "AlexGoot", 23))
            readAllData()
        }

        binding.update.setOnClickListener {
            viewModel.updateUser(User(list[0].id, "Jim", 25))
            readAllData()
        }

        binding.delete.setOnClickListener {
            if (list.isNotEmpty()) {
                viewModel.deleteUser(list[0])
                readAllData()
            }
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory()).get(UserViewModel::class.java)
        binding.recyclerView.apply {
            val layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager.orientation = RecyclerView.VERTICAL
            binding.recyclerView.layoutManager = layoutManager
            mAdapter = UsersAdapter()
            binding.recyclerView.adapter = mAdapter
        }
    }

    private fun readAllData() {
        viewModel.readAllData.observe(this, {
            if (it.isEmpty()) {
                binding.empty.visibility = View.VISIBLE
            } else {
                binding.empty.visibility = View.GONE
            }

            list = it.toMutableList()
            mAdapter.setUsers(list)
            mAdapter.notifyDataSetChanged()
        })
    }
}