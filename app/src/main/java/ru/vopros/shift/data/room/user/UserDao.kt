package ru.vopros.shift.data.room.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    suspend fun fetchAll(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun fetchById(id: String): UserEntity?

    @Insert
    suspend fun insertAll(vararg user: UserEntity)

}