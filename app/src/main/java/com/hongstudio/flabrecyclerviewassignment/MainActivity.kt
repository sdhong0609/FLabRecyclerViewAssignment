package com.hongstudio.flabrecyclerviewassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.asLiveData
import com.hongstudio.flabrecyclerviewassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()
    private val normalItemListAdapter = NormalItemListAdapter()
    private val trashItemListAdapter = TrashItemListAdapter()

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

        binding.recyclerViewNormalItems.adapter = normalItemListAdapter
        viewModel.normalItems.asLiveData().observe(this) {
            normalItemListAdapter.submitList(it)
        }

        binding.recyclerViewTrashItems.adapter = trashItemListAdapter
        viewModel.trashItems.asLiveData().observe(this) {
            trashItemListAdapter.submitList(it)
        }
    }
}