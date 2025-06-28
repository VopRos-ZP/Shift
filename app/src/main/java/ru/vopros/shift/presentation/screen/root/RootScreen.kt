package ru.vopros.shift.presentation.screen.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.vopros.shift.presentation.screen.Details
import ru.vopros.shift.presentation.screen.List
import ru.vopros.shift.presentation.screen.details.DetailsScreen
import ru.vopros.shift.presentation.screen.list.ListScreen

@Composable
fun RootScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = List
    ) {
        composable<List> {
            ListScreen(
                onUserClick = { navController.navigate(Details(it)) }
            )
        }
        composable<Details> {
            val route = it.toRoute<Details>()
            DetailsScreen(
                viewModel = koinViewModel(parameters = { parametersOf(route.id) }),
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}

