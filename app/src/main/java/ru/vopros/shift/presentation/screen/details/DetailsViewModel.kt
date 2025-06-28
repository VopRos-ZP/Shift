package ru.vopros.shift.presentation.screen.details

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import ru.vopros.shift.domain.usecase.GetUserUseCase

class DetailsViewModel(
    id: String,
    private val getUserUseCase: GetUserUseCase,
) : ViewModel(), ContainerHost<DetailsViewState, DetailsSideEffect> {

    override val container = container<DetailsViewState, DetailsSideEffect>(
        initialState = DetailsViewState(id = id),
        onCreate = {
            val user = getUserUseCase(id = state.id)
            reduce { state.copy(user = user) }
        }
    )

    fun onBackClick() = intent {
        postSideEffect(DetailsSideEffect.OnBackClick)
    }

}