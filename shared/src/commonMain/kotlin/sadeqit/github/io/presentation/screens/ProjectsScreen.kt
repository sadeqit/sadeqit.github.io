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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import sadeqit.github.io.domain.repository.ProjectRepository
import sadeqit.github.io.presentation.components.AppFooter
import sadeqit.github.io.presentation.components.ProjectCard
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.theme.AppBreakpoints
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun ProjectsScreen(
    onProjectClick: (String) -> Unit
) {
    val projectRepository = koinInject<ProjectRepository>()
    val projects = remember(projectRepository) {
        projectRepository.getProjects()
    }
    val spacing = AppDimensions.Space24

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val isMobile = maxWidth < AppBreakpoints.Mobile

        val columnCount = when {
            isMobile -> 1
            maxWidth < 900.dp -> 1
            else -> 3
        }


        val horizontalPadding = if (isMobile) 16.dp else 0.dp

        val contentModifier = Modifier
            .widthIn(max = 1250.dp)
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)

        val cardWidth = if (isMobile) {
            minOf(380.dp, maxWidth - horizontalPadding * 2)
        } else {
            400.dp
        }

        val projectRows = projects.chunked(columnCount)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = AppDimensions.Space32,
                bottom = 0.dp
            ),
            verticalArrangement = Arrangement.spacedBy(
                AppDimensions.Space8
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item(key = "projects-header") {
                HomeReveal {
                    Column(
                        modifier = contentModifier,
                        verticalArrangement = Arrangement.spacedBy(
                            AppDimensions.Space12
                        )
                    ) {
                        Text(
                            text = "آنچه ساخته‌ام",
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "ایده‌هایی که به محصول تبدیل شده‌اند؛ با تمرکز بر کیفیت و تجربه کاربری.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        Spacer(
                            modifier = Modifier.height(AppDimensions.Space8)
                        )

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
                        modifier = contentModifier,
                        verticalArrangement = Arrangement.spacedBy(
                            AppDimensions.Space16
                        )
                    ) {
                        Spacer(
                            Modifier.height(AppDimensions.Space16)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                spacing,
                                Alignment.CenterHorizontally
                            )
                        ) {
                            row.forEach { project ->
                                ProjectCard(
                                    modifier = Modifier.width(cardWidth),
                                    project = project,
                                    onClick = {
                                        onProjectClick(project.id)
                                    }
                                )
                            }
                        }

                        Spacer(
                            Modifier.height(AppDimensions.Space16)
                        )

                        if (index < projectRows.lastIndex) {
                            HorizontalDivider(
                                color = MaterialTheme.colorScheme.outlineVariant
                            )
                        }
                    }
                }
            }

            item {
                Spacer(
                    Modifier.height(AppDimensions.Space24)
                )
            }

            item(key = "app-footer") {
                Box(
                    Modifier.fillMaxWidth()
                ) {
                    CompositionLocalProvider(
                        LocalLayoutDirection provides LayoutDirection.Ltr
                    ) {
                        AppFooter()
                    }
                }
            }
        }
    }
}
