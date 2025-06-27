package ru.vopros.shift.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("gender")
    val gender: String,
    @SerialName("name")
    val nameDto: NameDto,
    @SerialName("location")
    val locationDto: LocationDto,
    @SerialName("email")
    val email: String,
    @SerialName("dob")
    val dobDto: DobDto,
    @SerialName("phone")
    val phone: String,
    @SerialName("cell")
    val cell: String,
    @SerialName("picture")
    val pictureDto: PictureDto,
    @SerialName("nat")
    val nat: String
)