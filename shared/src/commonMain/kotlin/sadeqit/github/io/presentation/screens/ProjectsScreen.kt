package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import sadeqit.github.io.domain.repository.ProjectRepository
import sadeqit.github.io.presentation.components.ProjectCard
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun ProjectsScreen(
    onProjectClick: (String) -> Unit
) {
    val projectRepository = koinInject<ProjectRepository>()
    val projects = projectRepository.getProjects()
    val spacing = AppDimensions.Space24

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppDimensions.ContentPadding)
    ) {
        val isMobile = maxWidth < 600.dp

        val cardWidth = if (isMobile) 300.dp else 340.dp

        val columnCount = if (isMobile) {
            1
        } else {
            ((maxWidth + spacing) / (cardWidth + spacing))
                .toInt()
                .coerceAtLeast(1)
        }
        val projectRows = projects.chunked(columnCount)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = AppDimensions.Space32,
                bottom = AppDimensions.Space48
            ),
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            item {
                HomeReveal {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(
                            AppDimensions.Space12
                        )
                    ) {
                        Text(
                            text = "PORTFOLIO",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.labelLarge
                        )
                        Text(
                            text = "آنچه ساخته‌ام",
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "ایده هایی که به محصول تبدیل شده اند؛ با تمرکز بر کیفیت و تجربه کاربری.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                        Spacer(modifier = Modifier.height(AppDimensions.Space8))
                        Text(
                            text = "پروژه‌ها",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold
                        )

                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                    }
                }
            }

            itemsIndexed(
                items = projectRows,
                key = { _, row ->
                    row.joinToString("-") { it.id }
                }
            ) { index, row ->
                HomeReveal {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(spacing)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(spacing)
                        ) {
                            row.forEach { project ->
                                Box(
                                    modifier = Modifier.weight(1f),
                                    contentAlignment = Alignment.TopCenter
                                ) {
                                    ProjectCard(
                                        modifier = Modifier.width(cardWidth),
                                        project = project,
                                        onClick = {
                                            onProjectClick(project.id)
                                        }
                                    )
                                }
                            }

                            if (row.size < columnCount) {
                                repeat(columnCount - row.size) {
                                    Spacer(
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }
                        }

                        if (index < projectRows.lastIndex) {
                            HorizontalDivider(
                                color = MaterialTheme.colorScheme.outlineVariant
                            )
                        }
                    }
                }
            }
        }
    }
}