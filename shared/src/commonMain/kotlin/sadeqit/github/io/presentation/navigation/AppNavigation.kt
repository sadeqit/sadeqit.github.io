package sadeqit.github.io.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.koin.compose.koinInject
import sadeqit.github.io.domain.repository.ProjectRepository
import sadeqit.github.io.presentation.components.AppShell
import sadeqit.github.io.presentation.screens.AboutScreen
import sadeqit.github.io.presentation.screens.ArticlesScreen
import sadeqit.github.io.presentation.screens.ContactScreen
import sadeqit.github.io.presentation.screens.HomeScreen
import sadeqit.github.io.presentation.screens.ProjectsScreen
import sadeqit.github.io.presentation.screens.ResumeScreen
import sadeqit.github.io.presentation.screens.projectScreen.ProjectDetailsScreen
import sadeqit.github.io.presentation.theme.AppThemeMode

@Composable
fun AppNavigation(
    browserRouter: BrowserRouter,
    themeMode: AppThemeMode,
    onThemeModeChange: (AppThemeMode) -> Unit
) {
    val projectRepository = koinInject<ProjectRepository>()
    val projects = projectRepository.getProjects()

    var currentRoute by remember(browserRouter) {
        mutableStateOf(browserRouter.currentPath().toAppRoute())
    }

    val navigateTo: (AppRoute) -> Unit = { route ->
        browserRouter.navigate(route.toPath())
        currentRoute = route
    }

    DisposableEffect(browserRouter) {
        browserRouter.listen { path ->
            currentRoute = path.toAppRoute()
        }

        onDispose {
            browserRouter.clearListener()
        }
    }

    AppShell(
        currentRoute = currentRoute,
        onNavigate = navigateTo,
        themeMode = themeMode,
        onThemeModeChange = onThemeModeChange
    ) {
        when (val route = currentRoute) {
            AppRoute.Home -> HomeScreen(
                onProjectsClick = {
                    navigateTo(AppRoute.Projects)
                },
                onProjectClick = { projectId ->
                    navigateTo(AppRoute.ProjectDetails(projectId))
                },
                onArticlesClick = {
                    navigateTo(AppRoute.Articles)
                },
                onAboutClick = {
                    navigateTo(AppRoute.About)
                },
                onContactClick = {
                    navigateTo(AppRoute.Contact)
                }
            )

            AppRoute.Projects -> ProjectsScreen(
                onProjectClick = { projectId ->
                    navigateTo(AppRoute.ProjectDetails(projectId))
                }
            )

            is AppRoute.ProjectDetails -> {
                val project = projects.find { it.id == route.projectId }

                if (project != null) {
                    ProjectDetailsScreen(
                        project = project,
                        onBackClick = {
                            browserRouter.back(AppRoute.Projects.toPath())
                        }
                    )
                } else {
                    ProjectsScreen(
                        onProjectClick = { projectId ->
                            navigateTo(AppRoute.ProjectDetails(projectId))
                        }
                    )
                }
            }

            AppRoute.Articles -> ArticlesScreen()
            AppRoute.Resume -> ResumeScreen()
            AppRoute.About -> AboutScreen()
            AppRoute.Contact -> ContactScreen()
        }
    }
}