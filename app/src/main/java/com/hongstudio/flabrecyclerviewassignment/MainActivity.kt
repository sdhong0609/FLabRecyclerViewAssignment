package com.hongstudio.flabrecyclerviewassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hongstudio.flabrecyclerviewassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val normalItemListAdapter = NormalItemListAdapter()

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
        normalItemListAdapter.submitList(
            listOf(
                NormalItem(id = 1, title = "Item 1"),
                NormalItem(id = 2, title = "Item 2"),
                NormalItem(id = 3, title = "Item 3"),
                NormalItem(id = 4, title = "Item 4"),
                NormalItem(id = 5, title = "Item 5"),
                NormalItem(id = 6, title = "Item 6"),
                NormalItem(id = 7, title = "Item 7"),
                NormalItem(id = 8, title = "Item 8"),
                NormalItem(id = 9, title = "Item 9"),
                NormalItem(id = 10, title = "Item 10")
            )
        )
    }
}