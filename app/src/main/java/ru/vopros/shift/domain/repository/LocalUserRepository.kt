package ru.vopros.shift.domain.repository

import ru.vopros.shift.domain.model.User

interface LocalUserRepository {
    suspend fun fetchUsers(): List<User>
    suspend fun fetchById(id: String): User?
    suspend fun insertAll(users: List<User>)
}