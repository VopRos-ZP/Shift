package ru.vopros.shift.domain.repository

import ru.vopros.shift.domain.model.User

interface RemoteUserRepository {
    suspend fun fetchUsers(results: Int): List<User>
}