package ru.vopros.shift.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreetDto(
    @SerialName("number")
    val number: Int,
    @SerialName("name")
    val name: String
)