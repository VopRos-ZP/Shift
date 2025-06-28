package ru.vopros.shift.presentation.screen

import kotlinx.serialization.Serializable

@Serializable
data object List

@Serializable
data class Details(val id: String)