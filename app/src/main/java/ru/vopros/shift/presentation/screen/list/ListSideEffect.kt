package ru.vopros.shift.presentation.screen.list

sealed interface ListSideEffect {
    data class OnUserClick(val value: String) : ListSideEffect
}