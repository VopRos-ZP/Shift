package ru.vopros.shift.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DobDto(
    @SerialName("date")
    val date: String,
    @SerialName("age")
    val age: Int
)