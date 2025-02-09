package com.hongstudio.flabrecyclerviewassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hongstudio.flabrecyclerviewassignment.common.TimeoutSecond
import com.hongstudio.flabrecyclerviewassignment.model.Item
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _normalItems: MutableStateFlow<List<Item.Normal>> = MutableStateFlow(
        (1L..10L).map { i ->
            Item.Normal(id = i, title = "Item $i")
        }
    )
    val normalItems = _normalItems.asStateFlow()

    private val _trashItems: MutableStateFlow<List<Item.Trash>> = MutableStateFlow(listOf())
    val trashItems = _trashItems.asStateFlow()

    private var countJob: Job? = null


    fun onTrashIconClick(item: Item) {
        _normalItems.update {
            it.toMutableList().also { newItems ->
                newItems.remove(item)
            }
        }
        _trashItems.update {
            it.toMutableList().also { newItems ->
                newItems.add(Item.Trash(id = item.id, title = item.title))
            }
        }

        setTimer()
    }

    fun onTrashItemClick(item: Item) {
        _normalItems.update {
            it.toMutableList().also { newItems ->
                newItems.add(Item.Normal(id = item.id, title = item.title))
            }
        }
        _trashItems.update {
            it.toMutableList().also { newItems ->
                newItems.remove(item)
            }
        }

        setTimer()
    }

    private fun setTimer() {
        countJob?.cancel()
        countJob = null

        if (_trashItems.value.isEmpty()) return

        countJob = viewModelScope.launch {
            _trashItems.update { items ->
                items.map {
                    it.copy(timeoutSecond = TimeoutSecond.INITIAL_TIMEOUT_SECOND)
                }
            }

            while (_trashItems.value.first().timeoutSecond > TimeoutSecond.ZERO) {
                delay(COUNTDOWN_DELAY_TIME_MILLIS)
                _trashItems.update { items ->
                    items.map {
                        it.copy(timeoutSecond = it.timeoutSecond - COUNTDOWN_SECOND)
                    }
                }
            }

            _trashItems.update { emptyList() }
        }
    }

    companion object {
        private const val COUNTDOWN_DELAY_TIME_MILLIS = 1000L
        private const val COUNTDOWN_SECOND = 1
    }
}