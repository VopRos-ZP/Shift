package ru.vopros.shift.presentation.screen.details

sealed interface DetailsSideEffect {
    data object OnBackClick : DetailsSideEffect
}