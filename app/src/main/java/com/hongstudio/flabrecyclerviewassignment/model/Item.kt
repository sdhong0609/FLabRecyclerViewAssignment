package com.hongstudio.flabrecyclerviewassignment.model

sealed interface Item {
    val id: Long
    val title: String

    data class Normal(
        override val id: Long,
        override val title: String
    ) : Item

    data class Trash(
        override val id: Long,
        override val title: String
    ) : Item
}