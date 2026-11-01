package sadeqit.github.io.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.components.AnimatedOutlinedButton
import sadeqit.github.io.presentation.components.ProjectCard
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeProjects(
    isMobile: Boolean,
    projects: List<Project>,
    onProjectsClick: () -> Unit,
    onProjectClick: (String) -> Unit
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
                            modifier = Modifier.width(300.dp),
                            project = project,
                            onClick = {
                                onProjectClick(project.id)
                            }
                        )
                    }
                } else {
                    projects.forEach { project ->
                        HomeReveal {
                            ProjectCard(
                                modifier = Modifier.width(340.dp),
                                project = project,
                                onClick = {
                                    onProjectClick(project.id)
                                }
                            )
                        }
                    }
                }
            }
            HomeRevealItem(
                index = 1,
                isMobile = isMobile
            ) {
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