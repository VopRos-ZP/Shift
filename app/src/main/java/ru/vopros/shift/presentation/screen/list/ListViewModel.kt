package ru.vopros.shift.presentation.screen.list

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import ru.vopros.shift.domain.model.User
import ru.vopros.shift.domain.usecase.GetUsersUseCase

class ListViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel(), ContainerHost<ListViewState, ListSideEffect> {

    override val container = container<ListViewState, ListSideEffect>(
        initialState = ListViewState(),
        onCreate = { refresh() }
    )

    fun refresh(isRefresh: Boolean = false) = intent {
        reduce { state.copy(isLoading = true) }
        getUsersUseCase(isRefresh = isRefresh).let {
            reduce { state.copy(isLoading = false, users = it) }
        }
    }

    fun onUserClick(user: User) = intent {
        postSideEffect(ListSideEffect.OnUserClick(user.id))
    }

}