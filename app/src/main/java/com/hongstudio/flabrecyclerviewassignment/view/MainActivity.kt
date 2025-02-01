package com.hongstudio.flabrecyclerviewassignment.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.asLiveData
import com.hongstudio.flabrecyclerviewassignment.R
import com.hongstudio.flabrecyclerviewassignment.databinding.ActivityMainBinding
import com.hongstudio.flabrecyclerviewassignment.model.Item
import com.hongstudio.flabrecyclerviewassignment.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()
    private val normalItemListAdapter = NormalItemListAdapter(::onTrashIconClick)
    private val trashItemListAdapter = TrashItemListAdapter(::onTrashItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setAdapters()
        setObservers()
    }

    private fun setAdapters() {
        binding.recyclerViewNormalItems.adapter = normalItemListAdapter
        binding.recyclerViewTrashItems.adapter = trashItemListAdapter
    }

    private fun setObservers() {
        viewModel.normalItems.asLiveData().observe(this) {
            normalItemListAdapter.submitList(it)
        }

        viewModel.trashItems.asLiveData().observe(this) {
            trashItemListAdapter.submitList(it)
        }

        viewModel.timeoutSecond.asLiveData().observe(this) {
            trashItemListAdapter.updateTimeout(it)
        }
    }

    private fun onTrashIconClick(item: Item) {
        viewModel.onTrashIconClick(item)
    }

    private fun onTrashItemClick(item: Item) {
        viewModel.onTrashItemClick(item)
    }
}