package sadeqit.github.io.presentation.screens.projectScreen.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.screens.projectScreen.components.FeatureChip
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectSection

@Composable
fun ProjectPlatformsSection(
    project: Project
) {
    if (project.platforms.isEmpty()) return
    HomeReveal {
        ProjectSection(
            title = "پلتفرم‌های پشتیبانی‌شده"
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                project.platforms.forEach { platform ->
                    FeatureChip(platform)
                }
            }
        }
    }
}