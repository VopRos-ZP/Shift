package ru.vopros.shift.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.vopros.shift.domain.usecase.GetUserUseCase
import ru.vopros.shift.domain.usecase.GetUsersUseCase
import ru.vopros.shift.presentation.screen.details.DetailsViewModel
import ru.vopros.shift.presentation.screen.list.ListViewModel

private val useCase = module {
    singleOf(::GetUsersUseCase)
    singleOf(::GetUserUseCase)
}

private val viewModel = module {
    viewModelOf(::ListViewModel)
    viewModelOf(::DetailsViewModel)
}

internal val presentationModule = module {
    includes(
        useCase,
        viewModel,
    )
}