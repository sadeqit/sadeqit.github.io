package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val isMobile = maxWidth < AppBreakpoints.Mobile

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            HomeHero(
                isMobile = isMobile,
                onProjectsClick = onProjectsClick,
                onContactClick = onContactClick
            )

            HomeSectionDivider()

            HomeAbout(
                isMobile = isMobile,
                onAboutClick = onAboutClick
            )

            HomeSectionDivider()

            HomeProjects(onProjectsClick = onProjectsClick)

            HomeSectionDivider()

            HomeSkills(isMobile = isMobile)

            HomeSectionDivider()

            HomeArticles(onArticlesClick = onArticlesClick)

            HomeSectionDivider()

            HomeApproach(isMobile = isMobile)

            HomeSectionDivider()

            HomeContact(
                isMobile = isMobile,
                onContactClick = onContactClick
            )
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
