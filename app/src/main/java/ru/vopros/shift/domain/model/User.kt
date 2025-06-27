package ru.vopros.shift.domain.model

data class User(
    val id: String,
    val gender: String,
    val name: String,
    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val email: String,
    val age: Int,
    val phone: String,
    val cell: String,
    val pictureLarge: String,
    val pictureMedium: String,
    val pictureThumbnail: String,
    val nat: String
)
