package sadeqit.github.io.presentation.navigation

sealed interface AppRoute {
    data object Home : AppRoute
}