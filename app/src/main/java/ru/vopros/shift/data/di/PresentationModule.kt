package ru.vopros.shift.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.vopros.shift.domain.usecase.GetUsersUseCase
import ru.vopros.shift.presentation.screen.root.RootViewModel

private val useCase = module {
    singleOf(::GetUsersUseCase)
}

private val viewModel = module {
    viewModelOf(::RootViewModel)
}

internal val presentationModule = module {
    includes(
        useCase,
        viewModel,
    )
}