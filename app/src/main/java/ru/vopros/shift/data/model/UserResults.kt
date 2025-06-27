package ru.vopros.shift.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResults(
    @SerialName("results")
    val results: List<UserDto>,
)
