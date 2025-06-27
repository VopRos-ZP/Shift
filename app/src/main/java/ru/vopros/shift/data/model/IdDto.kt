package ru.vopros.shift.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IdDto(
    @SerialName("name")
    val name: String,
    @SerialName("value")
    val value: String
)