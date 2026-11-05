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
fun ProjectFeaturesSection(
    project: Project
) {
    if (project.features.isEmpty()) return

    HomeReveal {
        ProjectSection(
            title = "قابلیت‌های اصلی",
            description = "امکانات و ویژگی‌های پیاده‌سازی‌شده در پروژه"
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                project.features.forEach { feature ->
                    FeatureChip(feature)
                }
            }
        }
    }

}