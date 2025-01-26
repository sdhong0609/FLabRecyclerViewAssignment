package com.hongstudio.flabrecyclerviewassignment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _normalItems: MutableStateFlow<List<NormalItem>> = MutableStateFlow(
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
    val normalItems = _normalItems.asStateFlow()

    private val _trashItems: MutableStateFlow<List<TrashItem>> = MutableStateFlow(
        listOf(
            TrashItem(id = 1, title = "Item 1", timeoutSecond = 3),
            TrashItem(id = 2, title = "Item 2", timeoutSecond = 3),
            TrashItem(id = 3, title = "Item 3", timeoutSecond = 3),
            TrashItem(id = 4, title = "Item 4", timeoutSecond = 3),
            TrashItem(id = 5, title = "Item 5", timeoutSecond = 3),
            TrashItem(id = 6, title = "Item 6", timeoutSecond = 3),
            TrashItem(id = 7, title = "Item 7", timeoutSecond = 3)
        )
    )
    val trashItems = _trashItems.asStateFlow()

}