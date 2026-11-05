package sadeqit.github.io.presentation.screens.projectScreen.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectLink
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectSection
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.ic_bazar
import sadeqit.shared.generated.resources.ic_github

@Composable
fun ProjectLinksSection(
    project: Project,
    isMobile: Boolean
) {
    val uriHandler = LocalUriHandler.current

    val githubUrl = project.githubUrl?.takeIf { it.isNotBlank() }
    val appUrl = project.appUrl?.takeIf { it.isNotBlank() }

    if (githubUrl == null && appUrl == null) return


    HomeReveal {
        ProjectSection(
            title = "لینک‌های پروژه"
        ) {
            val hasBothLinks = githubUrl != null && appUrl != null

            if (isMobile || !hasBothLinks) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        AppDimensions.Space16
                    )
                ) {
                    githubUrl?.let { url ->
                        ProjectLink(
                            title = "GitHub",
                            url = url,
                            icon = Res.drawable.ic_github,
                            onClick = { uriHandler.openUri(url) }
                        )
                    }

                    appUrl?.let { url ->
                        ProjectLink(
                            title = "کافه‌ بازار",
                            url = url,
                            icon = Res.drawable.ic_bazar,
                            onClick = { uriHandler.openUri(url) }
                        )
                    }
                }
            } else {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        AppDimensions.Space16
                    )
                ) {
                    githubUrl.let { url ->
                        ProjectLink(
                            modifier = Modifier.weight(1f),
                            title = "GitHub",
                            url = url,
                            icon = Res.drawable.ic_github,
                            onClick = { uriHandler.openUri(url) }
                        )
                    }

                    appUrl.let { url ->
                        ProjectLink(
                            modifier = Modifier.weight(1f),
                            title = "کافه‌ بازار",
                            url = url,
                            icon = Res.drawable.ic_bazar,
                            onClick = { uriHandler.openUri(url) }
                        )
                    }
                }
            }
        }
    }
}