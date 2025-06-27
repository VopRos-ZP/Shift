package ru.vopros.shift.presentation.screen.root

sealed interface RootSideEffect {
    data class OnUserClick(val value: String) : RootSideEffect
}