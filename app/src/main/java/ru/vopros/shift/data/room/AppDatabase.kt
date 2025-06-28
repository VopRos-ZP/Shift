package ru.vopros.shift.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.vopros.shift.data.room.user.UserDao
import ru.vopros.shift.data.room.user.UserEntity

@Database(
    version = 1,
    entities = [
        UserEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        const val NAME = "app_database"
    }
}