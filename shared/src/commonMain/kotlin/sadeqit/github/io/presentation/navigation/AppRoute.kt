package sadeqit.github.io.presentation.navigation

sealed interface AppRoute {

    data object Home : AppRoute

    data object Projects : AppRoute

    data object Articles : AppRoute

    data object Resume : AppRoute

    data object About : AppRoute

    data object Contact : AppRoute
}