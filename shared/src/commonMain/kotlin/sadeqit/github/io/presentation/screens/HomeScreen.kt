package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import org.koin.compose.koinInject
import sadeqit.github.io.domain.repository.ArticleRepository
import sadeqit.github.io.domain.repository.ProjectRepository
import sadeqit.github.io.presentation.components.AppFooter
import sadeqit.github.io.presentation.screens.home.HomeAbout
import sadeqit.github.io.presentation.screens.home.HomeApproach
import sadeqit.github.io.presentation.screens.home.HomeArticles
import sadeqit.github.io.presentation.screens.home.HomeContact
import sadeqit.github.io.presentation.screens.home.HomeHero
import sadeqit.github.io.presentation.screens.home.HomeProjects
import sadeqit.github.io.presentation.screens.home.HomeSkills
import sadeqit.github.io.presentation.theme.AppBreakpoints

@Composable
fun HomeScreen(
    onProjectsClick: () -> Unit,
    onArticlesClick: () -> Unit,
    onAboutClick: () -> Unit,
    onContactClick: () -> Unit,
) {
    val projectRepository = koinInject<ProjectRepository>()
    val articleRepository = koinInject<ArticleRepository>()

    val featuredProjects = projectRepository.getFeaturedProjects()
    val featuredArticles = articleRepository.getFeaturedArticles()

    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth()
    ) {
        val isMobile = maxWidth < AppBreakpoints.Mobile

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
        ) {
            item {
                HomeHero(
                    isMobile = isMobile,
                    onProjectsClick = onProjectsClick,
                    onContactClick = onContactClick
                )
            }

            item {
                HomeSectionDivider()
            }

            item {
                HomeAbout(
                    isMobile = isMobile,
                    onAboutClick = onAboutClick
                )
            }

            item {
                HomeSectionDivider()
            }

            item {
                HomeProjects(
                    isMobile = isMobile,
                    projects = featuredProjects,
                    onProjectsClick = onProjectsClick
                )
            }

            item {
                HomeSectionDivider()
            }

            item {
                HomeSkills(
                    isMobile = isMobile
                )
            }

            item {
                HomeSectionDivider()
            }

            item {
                HomeApproach(
                    isMobile = isMobile
                )
            }

            item {
                HomeSectionDivider()
            }

            item {
                HomeArticles(
                    isMobile = isMobile,
                    articles = featuredArticles,
                    onArticlesClick = onArticlesClick
                )
            }

            item {
                HomeSectionDivider()
            }

            item {
                HomeContact(
                    isMobile = isMobile,
                    onContactClick = onContactClick
                )
            }
            item {
                CompositionLocalProvider(
                    LocalLayoutDirection provides LayoutDirection.Ltr
                ) {
                    AppFooter()
                }
            }
        }
    }
}
@Composable
private fun HomeSectionDivider() {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.outlineVariant
    )
}
