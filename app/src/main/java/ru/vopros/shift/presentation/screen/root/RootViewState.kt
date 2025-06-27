package ru.vopros.shift.presentation.screen.root

import ru.vopros.shift.domain.model.User

data class RootViewState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
)