package ru.vopros.shift.data.mapper

import ru.vopros.shift.data.model.UserDto
import ru.vopros.shift.data.room.user.UserEntity
import ru.vopros.shift.domain.model.User

fun UserDto.fromDto(): User = User(
    id = phone,
    gender = gender,
    name = "${nameDto.title} ${nameDto.first} ${nameDto.last}",
    address = "${locationDto.city} ${locationDto.streetDto.name} ${locationDto.streetDto.number}",
    email = email,
    age = dobDto.age,
    phone = phone,
    cell = cell,
    pictureLarge = pictureDto.large,
    pictureMedium = pictureDto.medium,
    pictureThumbnail = pictureDto.thumbnail,
    nat = nat
)

fun UserEntity.fromEntity(): User = User(
    id = id,
    gender = gender,
    name = name,
    address = address,
    email = email,
    age = age,
    phone = phone,
    cell = cell,
    pictureLarge = pictureLarge,
    pictureMedium = pictureMedium,
    pictureThumbnail = pictureThumbnail,
    nat = nat
)

fun User.toEntity(): UserEntity = UserEntity(
    id = id,
    gender = gender,
    name = name,
    address = address,
    email = email,
    age = age,
    phone = phone,
    cell = cell,
    pictureLarge = pictureLarge,
    pictureMedium = pictureMedium,
    pictureThumbnail = pictureThumbnail,
    nat = nat
)