package ru.vopros.shift.data.mapper

import ru.vopros.shift.data.model.UserDto
import ru.vopros.shift.domain.model.User

fun UserDto.fromDto(): User = User(
    id = phone,
    gender = gender,
    name = "${nameDto.last} ${nameDto.first}",
    street = "${locationDto.streetDto.name} ${locationDto.streetDto.number}",
    city = locationDto.city,
    state = locationDto.state,
    country = locationDto.country,
    email = email,
    age = dobDto.age,
    phone = phone,
    cell = cell,
    pictureLarge = pictureDto.large,
    pictureMedium = pictureDto.medium,
    pictureThumbnail = pictureDto.thumbnail,
    nat = nat
)