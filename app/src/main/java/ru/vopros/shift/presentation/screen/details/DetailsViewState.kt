package ru.vopros.shift.presentation.screen.details

import ru.vopros.shift.domain.model.User

data class DetailsViewState(
    val id: String,
    val user: User? = null,
)