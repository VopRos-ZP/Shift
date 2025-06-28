package ru.vopros.shift.presentation.screen.list

import ru.vopros.shift.domain.model.User

data class ListViewState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
)
