package ru.vopros.shift.domain.usecase

import ru.vopros.shift.domain.Constants
import ru.vopros.shift.domain.model.User
import ru.vopros.shift.domain.repository.UserRepository

class GetUsersUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(
        results: Int = Constants.RESULTS
    ): List<User> = userRepository.fetchUsers(results)

}