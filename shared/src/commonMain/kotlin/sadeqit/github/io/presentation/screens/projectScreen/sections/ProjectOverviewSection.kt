package sadeqit.github.io.presentation.screens.projectScreen.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.components.AnimatedOutlinedButton
import sadeqit.github.io.presentation.components.card.ProjectInfoChip
import sadeqit.github.io.presentation.components.card.ProjectReleaseChip
import sadeqit.github.io.presentation.components.card.ProjectTypeChip
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.screens.home.HomeRevealItem
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectSection
import sadeqit.github.io.presentation.theme.AppColors
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun ProjectOverviewSection(
    project: Project,
    isMobile: Boolean,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        HomeReveal {
            ProjectSection(
                title = "معرفی پروژه",
                description = "آشنایی با پروژه و هدف اصلی توسعه آن"
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        ProjectInfoChip(
                            label = project.status,
                            backgroundColor = AppColors.ProjectStatusBackground,
                            textColor = AppColors.ProjectStatus
                        )

                        ProjectTypeChip(project.projectType)

                        ProjectReleaseChip(project.releaseType)
                    }

                    Text(
                        text = project.title,
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Text(
                        text = project.description,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    if (project.fullDescription.isNotBlank()) {
                        Text(
                            text = project.fullDescription.trim(),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.6
                        )
                    }

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space12),
                        verticalArrangement = Arrangement.spacedBy(AppDimensions.Space12)
                    ) {
                        project.githubUrl
                            ?.takeIf { it.isNotBlank() }
                            ?.let { url ->
                                HomeRevealItem(
                                    index = 0,
                                    isMobile = isMobile
                                ) {
                                    val hoverEffect = rememberHoverEffect(
                                        enableScale = true,
                                        scale = 1.04f
                                    )

                                    Button(
                                        onClick = { uriHandler.openUri(url) },
                                        modifier = Modifier.graphicsLayer {
                                            scaleX = hoverEffect.scale
                                            scaleY = hoverEffect.scale
                                        },
                                        interactionSource = hoverEffect.interactionSource,
                                        shape = MaterialTheme.shapes.medium
                                    ) {
                                        Text("مشاهده سورس کد")
                                    }
                                }
                            }

                        project.appUrl
                            ?.takeIf { it.isNotBlank() }
                            ?.let { url ->
                                HomeRevealItem(
                                    index = 1,
                                    isMobile = isMobile
                                ) {
                                    AnimatedOutlinedButton(
                                        onClick = { uriHandler.openUri(url) }
                                    ) {
                                        Text("مشاهده در کافه‌ بازار")
                                    }
                                }
                            }
                    }
                }
            }
        }
    }
}