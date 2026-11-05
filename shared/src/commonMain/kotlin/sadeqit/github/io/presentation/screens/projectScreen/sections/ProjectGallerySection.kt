package sadeqit.github.io.presentation.screens.projectScreen.sections

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.screens.home.HorizontalCardRow
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectScreenshot
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectSection

@Composable
fun ProjectGallerySection(
    project: Project,
    isMobile: Boolean
) {
    if (project.screenshots.isEmpty()) return

    HomeReveal {
        ProjectSection(
            title = "تصاویر پروژه",
            description = "نمایی از رابط کاربری و بخش‌های مختلف برنامه"
        ) {
            HorizontalCardRow {
                project.screenshots.forEach { screenshot ->
                    ProjectScreenshot(
                        name = screenshot,
                        modifier = Modifier
                            .width(300.dp)
                            .height(if (isMobile) 600.dp else 580.dp)
                    )
                }
            }
        }
    }
}