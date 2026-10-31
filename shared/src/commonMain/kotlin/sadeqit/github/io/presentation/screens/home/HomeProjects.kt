package sadeqit.github.io.presentation.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.components.AnimatedOutlinedButton
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeProjects(
    isMobile: Boolean,
    projects: List<Project>,
    onProjectsClick: () -> Unit,
) {

    HomeContainer(
        modifier = Modifier.padding(
            vertical = AppDimensions.Space48
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                AppDimensions.Space40
            )
        ) {
            HomeReveal {
                SectionHeader(
                    eyebrow = "SELECTED PROJECTS",
                    title = "پروژه‌های منتخب",
                    description = "از ایده تا انتشار — پروژه هایی که با هدف ساخت تجربه ای کاربردی و قابل اعتماد شکل گرفته اند."
                )
            }
            HorizontalCardRow {
                if (isMobile) {
                    projects.forEach { project ->
                        ProjectCard(
                            modifier = Modifier.width(280.dp),
                            project = project,
                            onClick = onProjectsClick
                        )
                    }
                } else {
                    projects.forEach { project ->
                        HomeReveal {
                            ProjectCard(
                                modifier = Modifier.width(280.dp),
                                project = project,
                                onClick = onProjectsClick
                            )
                        }
                    }
                }
            }
            HomeReveal {
                AnimatedOutlinedButton(
                    onClick = onProjectsClick,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("مشاهده همه پروژه‌ها")
                }

            }
        }
    }
}
@Composable
private fun ProjectCard(
    modifier: Modifier = Modifier,
    project: Project,
    onClick: () -> Unit,
) {
    val hoverEffect = rememberHoverEffect(
        enableScale = true
    )

    Card(
        onClick = onClick,
        modifier = modifier.graphicsLayer {
            scaleX = hoverEffect.scale
            scaleY = hoverEffect.scale
        },
        border = BorderStroke(
            width = AppDimensions.BorderThin,
            brush = hoverEffect.borderBrush
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        interactionSource = hoverEffect.interactionSource,
    ) {
        Column(
            modifier = Modifier.padding(AppDimensions.Space20),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space16)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppDimensions.Space96 + AppDimensions.Space24)
                    .clip(RoundedCornerShape(AppDimensions.Space12))
                    .background(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.07f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "</>",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.65f),
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = project.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space8)
            ) {
                project.technologies.forEach { SkillChip(it) }
            }
        }
    }
}
