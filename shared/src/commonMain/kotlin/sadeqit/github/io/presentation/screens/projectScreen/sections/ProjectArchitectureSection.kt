package sadeqit.github.io.presentation.screens.projectScreen.sections

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectSection

@Composable
fun ProjectArchitectureSection(
    project: Project
) {
    if (project.architecture.isBlank()) return

    HomeReveal {
        ProjectSection(
            title = "معماری و ساختار فنی",
            description = "نگاهی به ساختار داخلی و تصمیم‌های معماری پروژه"
        ) {
            Text(
                text = project.architecture.trim(),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.6
            )
        }
    }
}