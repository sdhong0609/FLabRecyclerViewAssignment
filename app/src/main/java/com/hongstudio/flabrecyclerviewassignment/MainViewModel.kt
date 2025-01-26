package com.hongstudio.flabrecyclerviewassignment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _normalItems: MutableStateFlow<List<Item>> = MutableStateFlow(
        listOf(
            Item(id = 1, title = "Item 1"),
            Item(id = 2, title = "Item 2"),
            Item(id = 3, title = "Item 3"),
            Item(id = 4, title = "Item 4"),
            Item(id = 5, title = "Item 5"),
            Item(id = 6, title = "Item 6"),
            Item(id = 7, title = "Item 7"),
            Item(id = 8, title = "Item 8"),
            Item(id = 9, title = "Item 9"),
            Item(id = 10, title = "Item 10")
        )
    )
    val normalItems = _normalItems.asStateFlow()

    private val _trashItems: MutableStateFlow<List<Item>> = MutableStateFlow(listOf())
    val trashItems = _trashItems.asStateFlow()

    fun onTrashIconClick(item: Item) {
        _normalItems.update {
            val newItems = it.toMutableList()
            newItems.remove(item)
            newItems.toList()
        }
        _trashItems.update {
            val newItems = it.toMutableList()
            newItems.add(item)
            newItems.toList()
        }
    }

    fun onTrashItemClick(item: Item) {
        _normalItems.update {
            val newItems = it.toMutableList()
            newItems.add(item)
            newItems.toList()
        }
        _trashItems.update {
            val newItems = it.toMutableList()
            newItems.remove(item)
            newItems.toList()
        }
    }
}