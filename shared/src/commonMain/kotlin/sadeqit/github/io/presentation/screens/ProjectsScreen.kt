package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import sadeqit.github.io.domain.repository.ProjectRepository
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun ProjectsScreen() {
    val projectRepository = koinInject<ProjectRepository>()
    val projects = projectRepository.getProjects()

    Text(
        text = "Projects: ${projects.size}",
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimensions.ContentPadding)
    )
}