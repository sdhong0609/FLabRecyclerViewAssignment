package com.hongstudio.flabrecyclerviewassignment.model

import com.hongstudio.flabrecyclerviewassignment.common.TimeoutSecond

sealed interface Item {
    val id: Long
    val title: String

    data class Normal(
        override val id: Long,
        override val title: String
    ) : Item

    data class Trash(
        override val id: Long,
        override val title: String,
        val timeoutSecond : Int = TimeoutSecond.INITIAL_TIMEOUT_SECOND
    ) : Item
}