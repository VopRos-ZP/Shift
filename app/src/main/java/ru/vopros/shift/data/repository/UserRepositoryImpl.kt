package ru.vopros.shift.data.repository

import ru.vopros.shift.data.mapper.fromDto
import ru.vopros.shift.data.model.UserDto
import ru.vopros.shift.data.retrofit.UserApi
import ru.vopros.shift.domain.model.User
import ru.vopros.shift.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userApi: UserApi
) : UserRepository {

    override suspend fun fetchUsers(results: Int): List<User> {
        return userApi.fetchUsers(results)
            .results
            .map(UserDto::fromDto)
    }

}