package ru.vopros.shift.presentation.screen.root

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import ru.vopros.shift.domain.model.User
import ru.vopros.shift.domain.usecase.GetUsersUseCase

class RootViewModel(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel(), ContainerHost<RootViewState, RootSideEffect> {

    override val container = container<RootViewState, RootSideEffect>(
        initialState = RootViewState(),
        onCreate = { refresh() }
    )

    fun refresh() = intent {
        reduce { state.copy(isLoading = true) }
        getUsersUseCase().let {
            reduce { state.copy(isLoading = false, users = it) }
        }
    }

    fun onUserClick(user: User) = intent {
        postSideEffect(RootSideEffect.OnUserClick(user.id))
    }

}