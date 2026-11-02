package sadeqit.github.io.presentation.screens.projectScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun ProjectDetailsScreen(
    project: Project,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = AppDimensions.Space24),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = AppDimensions.ContentMaxWidth),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space24)
        ) {
            ProjectOverview(project)
        }
    }
}

@Composable
private fun ProjectOverview(
    project: Project
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(AppDimensions.Space12)
    ) {
        Text(
            text = project.title,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = project.description,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = project.fullDescription,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}