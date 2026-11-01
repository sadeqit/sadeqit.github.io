package sadeqit.github.io.presentation.navigation

sealed interface AppRoute {

    data object Home : AppRoute

    data object Projects : AppRoute

    data class ProjectDetails(val projectId: String) : AppRoute

    data object Articles : AppRoute

    data object Resume : AppRoute

    data object About : AppRoute

    data object Contact : AppRoute
}