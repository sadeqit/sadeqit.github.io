package sadeqit.github.io.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import sadeqit.github.io.presentation.components.AppShell
import sadeqit.github.io.presentation.screens.AboutScreen
import sadeqit.github.io.presentation.screens.ArticlesScreen
import sadeqit.github.io.presentation.screens.ContactScreen
import sadeqit.github.io.presentation.screens.HomeScreen
import sadeqit.github.io.presentation.screens.ProjectsScreen
import sadeqit.github.io.presentation.screens.ResumeScreen

@Composable
fun AppNavigation() {
    var currentRoute by remember {
        mutableStateOf<AppRoute>(AppRoute.Home)
    }

    AppShell(
        currentRoute = currentRoute,
        onNavigate = { route ->
            currentRoute = route
        }
    ) {
        when (currentRoute) {
            AppRoute.Home -> HomeScreen()
            AppRoute.Projects -> ProjectsScreen()
            AppRoute.Articles -> ArticlesScreen()
            AppRoute.Resume -> ResumeScreen()
            AppRoute.About -> AboutScreen()
            AppRoute.Contact -> ContactScreen()
        }
    }
}