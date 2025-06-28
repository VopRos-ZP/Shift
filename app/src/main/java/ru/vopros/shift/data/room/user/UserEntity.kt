package ru.vopros.shift.data.room.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "address")
    val address: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "cell")
    val cell: String,
    @ColumnInfo(name = "picture_large")
    val pictureLarge: String,
    @ColumnInfo(name = "picture_medium")
    val pictureMedium: String,
    @ColumnInfo(name = "picture_thumbnail")
    val pictureThumbnail: String,
    @ColumnInfo(name = "nat")
    val nat: String
)
