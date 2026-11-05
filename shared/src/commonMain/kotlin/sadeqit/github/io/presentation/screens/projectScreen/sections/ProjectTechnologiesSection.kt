package sadeqit.github.io.presentation.screens.projectScreen.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectSection
import sadeqit.github.io.presentation.screens.projectScreen.components.TechnologyChip

@Composable
fun ProjectTechnologiesSection(
    project: Project
) {
    if (project.technologies.isEmpty()) return
    HomeReveal {
        ProjectSection(
            title = "فناوری‌های استفاده‌شده",
            description = "ابزارها و تکنولوژی‌های به‌کاررفته در توسعه پروژه"
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                project.technologies.forEach { technology ->
                    TechnologyChip(technology)
                }
            }
        }
    }
}