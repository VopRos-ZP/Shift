package ru.vopros.shift.domain.usecase

import ru.vopros.shift.domain.Constants
import ru.vopros.shift.domain.model.User
import ru.vopros.shift.domain.repository.LocalUserRepository
import ru.vopros.shift.domain.repository.RemoteUserRepository

class GetUsersUseCase(
    private val remoteUserRepository: RemoteUserRepository,
    private val localUserRepository: LocalUserRepository,
) {

    suspend operator fun invoke(
        results: Int = Constants.RESULTS,
        isRefresh: Boolean = false,
    ): List<User> {
        var result = localUserRepository.fetchUsers().reversed()
        if (result.isEmpty() || isRefresh) {
            result = remoteUserRepository.fetchUsers(results)
            localUserRepository.insertAll(result.reversed())
        }
        return result
    }

}