package sadeqit.github.io.presentation.screens.projectScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.components.AnimatedOutlinedButton
import sadeqit.github.io.presentation.components.AppFooter
import sadeqit.github.io.presentation.components.ProjectInfoChip
import sadeqit.github.io.presentation.components.ProjectReleaseChip
import sadeqit.github.io.presentation.components.ProjectTypeChip
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.screens.home.HomeRevealItem
import sadeqit.github.io.presentation.screens.home.HorizontalCardRow
import sadeqit.github.io.presentation.screens.projectScreen.components.ChallengeCard
import sadeqit.github.io.presentation.screens.projectScreen.components.FeatureChip
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectLink
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectListItem
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectScreenshot
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectSection
import sadeqit.github.io.presentation.screens.projectScreen.components.TechnologyChip
import sadeqit.github.io.presentation.theme.AppBreakpoints
import sadeqit.github.io.presentation.theme.AppColors
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.ic_bazar
import sadeqit.shared.generated.resources.ic_github

@Composable
fun ProjectDetailsScreen(
    project: Project
) {
    val uriHandler = LocalUriHandler.current

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val isMobile = maxWidth < AppBreakpoints.Mobile

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = 1200.dp)
                    .padding(horizontal = 24.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            )
            {
                // Project Overview
                HomeReveal {
                    ProjectSection(
                        title = "معرفی پروژه",
                        description = "آشنایی با پروژه و هدف اصلی توسعه آن"
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                ProjectInfoChip(
                                    label = project.status,
                                    backgroundColor = AppColors.ProjectStatusBackground,
                                    textColor = AppColors.ProjectStatus
                                )

                                ProjectTypeChip(project.projectType)

                                ProjectReleaseChip(project.releaseType)
                            }

                            Text(
                                text = project.title,
                                style = MaterialTheme.typography.displaySmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground
                            )

                            Text(
                                text = project.description,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )

                            if (project.fullDescription.isNotBlank()) {
                                Text(
                                    text = project.fullDescription.trim(),
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.6
                                )
                            }

                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space12),
                                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space12)
                            ) {
                                project.githubUrl
                                    ?.takeIf { it.isNotBlank() }
                                    ?.let { url ->
                                        HomeRevealItem(
                                            index = 0,
                                            isMobile = isMobile
                                        ) {
                                            val hoverEffect = rememberHoverEffect(
                                                enableScale = true,
                                                scale = 1.04f
                                            )

                                            Button(
                                                onClick = { uriHandler.openUri(url) },
                                                modifier = Modifier.graphicsLayer {
                                                    scaleX = hoverEffect.scale
                                                    scaleY = hoverEffect.scale
                                                },
                                                interactionSource = hoverEffect.interactionSource,
                                                shape = MaterialTheme.shapes.medium
                                            ) {
                                                Text("مشاهده سورس کد")
                                            }
                                        }
                                    }

                                project.appUrl
                                    ?.takeIf { it.isNotBlank() }
                                    ?.let { url ->
                                        HomeRevealItem(
                                            index = 1,
                                            isMobile = isMobile
                                        ) {
                                            AnimatedOutlinedButton(
                                                onClick = { uriHandler.openUri(url) }
                                            ) {
                                                Text("مشاهده در کافه‌ بازار")
                                            }
                                        }
                                    }
                            }
                        }
                    }
                }

                // Screenshots Gallery
                if (project.screenshots.isNotEmpty()) {
                    HomeReveal {
                        ProjectSection(
                            title = "تصاویر پروژه",
                            description = "نمایی از رابط کاربری و بخش‌ های مختلف برنامه"
                        ) {
                            HorizontalCardRow {
                                if (isMobile) {
                                    project.screenshots.forEach { screenshot ->
                                        ProjectScreenshot(
                                            name = screenshot,
                                            modifier = Modifier
                                                .width(300.dp)
                                                .height(600.dp)
                                        )
                                    }
                                } else {
                                    project.screenshots.forEach { screenshot ->
                                        ProjectScreenshot(
                                            name = screenshot,
                                            modifier = Modifier
                                                .width(300.dp)
                                                .height(580.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Project Goals
                if (project.goals.isNotEmpty()) {
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

                // Features
                if (project.features.isNotEmpty()) {
                    HomeReveal {
                        ProjectSection(
                            title = "قابلیت‌ های اصلی",
                            description = "امکانات و ویژگی‌ های پیاده ‌سازی‌ شده در پروژه"
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

                // Technologies
                if (project.technologies.isNotEmpty()) {
                    HomeReveal {
                        ProjectSection(
                            title = "فناوری‌ های استفاده‌ شده",
                            description = "ابزارها و تکنولوژی‌ های به‌ کار رفته در توسعه پروژه"
                        ) {
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                project.technologies.forEach { technology ->
                                    TechnologyChip(technology)
                                }
                            }
                        }
                    }
                }

                // Platforms
                if (project.platforms.isNotEmpty()) {
                    HomeReveal {
                        ProjectSection(
                            title = "پلتفرم‌ های پشتیبانی ‌شده"
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

                // Architecture
                if (project.architecture.isNotBlank()) {
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

                // Technical Challenges
                if (project.challenges.isNotEmpty()) {
                    HomeReveal {
                        ProjectSection(
                            title = "چالش‌های فنی و راه‌حل‌ها",
                            description = "برخی از چالش‌های مهم توسعه و راهکارهای به‌کارگرفته‌شده"
                        ) {
                            FlowRow(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(
                                    AppDimensions.Space16
                                ),
                                verticalArrangement = Arrangement.spacedBy(
                                    AppDimensions.Space16
                                ),
                                maxItemsInEachRow = if (isMobile) 1 else 2
                            ) {
                                project.challenges.forEachIndexed { index, challenge ->
                                    ChallengeCard(
                                        modifier = Modifier.weight(1f),
                                        index = index + 1,
                                        challenge = challenge
                                    )
                                }
                            }
                        }
                    }
                }

                // Project Links
                if (project.githubUrl != null || project.appUrl != null) {
                    HomeReveal {
                        ProjectSection(
                            title = "لینک‌ های پروژه"
                        ) {
                            val hasBothLinks =
                                project.githubUrl != null && project.appUrl != null

                            if (isMobile || !hasBothLinks) {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(
                                        AppDimensions.Space16
                                    )
                                ) {
                                    project.githubUrl?.let { url ->
                                        ProjectLink(
                                            title = "GitHub",
                                            url = url,
                                            icon = Res.drawable.ic_github,
                                            onClick = { uriHandler.openUri(url) }
                                        )
                                    }

                                    project.appUrl?.let { url ->
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
                                    project.githubUrl.let { url ->
                                        ProjectLink(
                                            modifier = Modifier.weight(1f),
                                            title = "GitHub",
                                            url = url,
                                            icon = Res.drawable.ic_github,
                                            onClick = { uriHandler.openUri(url) }
                                        )
                                    }

                                    project.appUrl.let { url ->
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
            }
            CompositionLocalProvider(
                LocalLayoutDirection provides LayoutDirection.Ltr
            ) {
                AppFooter()
            }
        }
    }
}