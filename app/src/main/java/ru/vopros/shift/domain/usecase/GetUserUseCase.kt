package ru.vopros.shift.domain.usecase

import ru.vopros.shift.domain.model.User
import ru.vopros.shift.domain.repository.LocalUserRepository

class GetUserUseCase(
    private val localUserRepository: LocalUserRepository
) {

    suspend operator fun invoke(id: String): User? =
        localUserRepository.fetchById(id)

}