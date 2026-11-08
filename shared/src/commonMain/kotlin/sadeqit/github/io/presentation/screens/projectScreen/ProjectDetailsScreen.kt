package sadeqit.github.io.presentation.screens.projectScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.components.AppFooter
import sadeqit.github.io.presentation.screens.projectScreen.sections.ProjectArchitectureSection
import sadeqit.github.io.presentation.screens.projectScreen.sections.ProjectChallengesSection
import sadeqit.github.io.presentation.screens.projectScreen.sections.ProjectFeaturesSection
import sadeqit.github.io.presentation.screens.projectScreen.sections.ProjectGallerySection
import sadeqit.github.io.presentation.screens.projectScreen.sections.ProjectGoalsSection
import sadeqit.github.io.presentation.screens.projectScreen.sections.ProjectLinksSection
import sadeqit.github.io.presentation.screens.projectScreen.sections.ProjectOverviewSection
import sadeqit.github.io.presentation.screens.projectScreen.sections.ProjectPlatformsSection
import sadeqit.github.io.presentation.screens.projectScreen.sections.ProjectTechnologiesSection
import sadeqit.github.io.presentation.theme.AppBreakpoints

@Composable
fun ProjectDetailsScreen(
    project: Project
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val isMobile = maxWidth < AppBreakpoints.Mobile

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
            top = 20.dp, bottom = 0.dp
            ),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item(key = "overview") {
                ProjectDetailsItem {
                    ProjectOverviewSection(
                        project = project,
                        isMobile = isMobile
                    )
                }
            }

            if (project.screenshots.isNotEmpty()) {
                item(key = "gallery") {
                    ProjectDetailsItem {
                        ProjectGallerySection(
                            project = project,
                            isMobile = isMobile
                        )
                    }
                }
            }

            if (project.goals.isNotEmpty()) {
                item(key = "goals") {
                    ProjectDetailsItem {
                        ProjectGoalsSection(project)
                    }
                }
            }

            if (project.features.isNotEmpty()) {
                item(key = "features") {
                    ProjectDetailsItem {
                        ProjectFeaturesSection(project)
                    }
                }
            }

            if (project.technologies.isNotEmpty()) {
                item(key = "technologies") {
                    ProjectDetailsItem {
                        ProjectTechnologiesSection(project)
                    }
                }
            }

            if (project.platforms.isNotEmpty()) {
                item(key = "platforms") {
                    ProjectDetailsItem {
                        ProjectPlatformsSection(project)
                    }
                }
            }

            if (project.architecture.isNotBlank()) {
                item(key = "architecture") {
                    ProjectDetailsItem {
                        ProjectArchitectureSection(project)
                    }
                }
            }

            if (project.challenges.isNotEmpty()) {
                item(key = "challenges") {
                    ProjectDetailsItem {
                        ProjectChallengesSection(
                            project = project,
                            isMobile = isMobile
                        )
                    }
                }
            }

            if (
                !project.githubUrl.isNullOrBlank() ||
                !project.appUrl.isNullOrBlank()
            ) {
                item(key = "links") {
                    ProjectDetailsItem {
                        ProjectLinksSection(
                            project = project,
                            isMobile = isMobile
                        )
                    }
                }
            }

            item(key = "footer") {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    androidx.compose.runtime.CompositionLocalProvider(
                        LocalLayoutDirection provides LayoutDirection.Ltr
                    ) {
                        AppFooter()
                    }
                }
            }

        }
    }
}

@Composable
private fun ProjectDetailsItem(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 1200.dp)
                .padding(horizontal = 24.dp)
        ) {
            content()
        }
    }
}