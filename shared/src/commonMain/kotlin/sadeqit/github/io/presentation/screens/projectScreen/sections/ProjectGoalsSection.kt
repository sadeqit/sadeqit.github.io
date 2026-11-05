package sadeqit.github.io.presentation.screens.projectScreen.sections

import androidx.compose.runtime.Composable
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectListItem
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectSection

@Composable
fun ProjectGoalsSection(
    project: Project
) {
    if (project.goals.isEmpty()) return

    HomeReveal {
        ProjectSection(
            title = "اهداف پروژه",
            description = "مسئله‌ ها و اهدافی که در توسعه این پروژه دنبال شده‌اند"
        ) {
            project.goals.forEachIndexed { index, goal ->
                ProjectListItem(
                    number = index + 1,
                    text = goal
                )
            }
        }
    }
}