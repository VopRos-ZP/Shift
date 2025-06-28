package ru.vopros.shift.data.repository

import ru.vopros.shift.data.mapper.fromEntity
import ru.vopros.shift.data.mapper.toEntity
import ru.vopros.shift.data.room.AppDatabase
import ru.vopros.shift.data.room.user.UserEntity
import ru.vopros.shift.domain.model.User
import ru.vopros.shift.domain.repository.LocalUserRepository

class LocalUserRepositoryImpl(
    private val appDatabase: AppDatabase
) : LocalUserRepository {

    override suspend fun fetchUsers(): List<User> {
        return appDatabase.userDao.fetchAll().map(UserEntity::fromEntity)
    }

    override suspend fun fetchById(id: String): User? {
        return appDatabase.userDao.fetchById(id)?.fromEntity()
    }

    override suspend fun insertAll(users: List<User>) {
        users.map(User::toEntity).forEach {
            appDatabase.userDao.insertAll(it)
        }
    }

}