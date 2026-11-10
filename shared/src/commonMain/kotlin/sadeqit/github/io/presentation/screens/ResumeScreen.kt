package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import sadeqit.github.io.domain.model.ResumeProject
import sadeqit.github.io.domain.model.ResumeSocialLink
import sadeqit.github.io.domain.repository.ResumeRepository
import sadeqit.github.io.presentation.components.AppFooter
import sadeqit.github.io.presentation.components.ResumeProjectCard
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.theme.AppBreakpoints
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.gmail
import sadeqit.shared.generated.resources.ic_github
import sadeqit.shared.generated.resources.instagram
import sadeqit.shared.generated.resources.linkedin
import sadeqit.shared.generated.resources.telegram

@Composable
fun ResumeScreen(
    onProjectClick: (String) -> Unit
) {
    val repository = koinInject<ResumeRepository>()
    val resume = remember { repository.getResume() }
    val uriHandler = LocalUriHandler.current

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val isMobile = maxWidth < AppBreakpoints.Mobile

        val contentModifier = Modifier
            .widthIn(max = 960.dp)
            .fillMaxWidth()
            .padding(horizontal = if (isMobile) 16.dp else 0.dp)

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item(key = "resume-header") {
                HomeReveal {
                    Column(
                        modifier = contentModifier,
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Text(
                            text = resume.fullName,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                        )

                    }
                }
            }
            item(key = "divider-summary") {
                Box(
                    modifier = contentModifier,
                ) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp,
                    )
                }
            }

            item(key = "resume-summary") {
                HomeReveal {
                    ResumeSection(
                        title = "معرفی",
                        modifier = contentModifier,
                    ) {
                        Text(
                            text = resume.summary,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Justify
                        )
                    }
                }
            }
            item(key = "divider-skills") {
                Box(
                    modifier = contentModifier,
                ) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp,
                    )
                }
            }

            item(key = "resume-skills") {
                HomeReveal {
                    ResumeSection(
                        title = "مهارت‌ های فنی",
                        modifier = contentModifier,
                    ) {
                        resume.skills.forEach { category ->
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp),
                            ) {
                                Text(
                                    text = category.title,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colorScheme.onBackground,
                                )

                                SkillList(skills = category.skills)
                            }
                        }
                    }
                }
            }
            item(key = "divider-experiences") {
                Box(
                    modifier = contentModifier,
                ) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp,
                    )
                }
            }

            item(key = "resume-experiences") {
                HomeReveal {
                    ResumeSection(
                        title = "سوابق فعالیت",
                        modifier = contentModifier,
                    ) {
                        resume.experiences.forEach { experience ->
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp),
                            ) {
                                Text(
                                    text = experience.title,
                                    style = MaterialTheme.typography.titleLarge,
                                    color = MaterialTheme.colorScheme.onBackground,
                                )
                                Spacer(Modifier.height(12.dp))
                                Text(
                                    text = experience.description,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onBackground,
                                )
                            }
                        }
                    }
                }
            }
            item(key = "divider-projects") {
                Box(
                    modifier = contentModifier,
                ) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp,
                    )
                }
            }

            item(key = "resume-projects") {
                HomeReveal {
                    ResumeSection(
                        title = "پروژه‌های منتخب",
                        modifier = contentModifier,
                    ) {
                        resume.projects.forEach { project ->
                            ResumeProjectCard(
                                project = project,
                                onGithubClick = {
                                    project.githubUrl?.let(uriHandler::openUri)
                                },
                                onAppClick = {
                                    project.appUrl?.let(uriHandler::openUri)
                                },
                                onDetailsClick = {
                                    project.projectId?.let(onProjectClick)
                                },
                            )
                        }
                    }
                }
            }
            item(key = "divider-social-links") {
                Box(
                    modifier = contentModifier,
                ) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 2.dp,
                    )
                }
            }
            item(key = "resume-social-links") {
                HomeReveal {
                    ResumeSection(
                        title = "راه‌ های ارتباطی",
                        modifier = contentModifier,
                    ) {
                        BoxWithConstraints(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            val isMobile = maxWidth < AppBreakpoints.Mobile

                            if (isMobile) {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                ) {
                                    resume.socialLinks.forEach { link ->
                                        SocialLinkItem(
                                            link = link,
                                            modifier = Modifier.fillMaxWidth(),
                                            onClick = { uriHandler.openUri(link.url) },
                                        )
                                    }
                                }
                            } else {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                ) {
                                    resume.socialLinks.forEach { link ->
                                        SocialLinkItem(
                                            link = link,
                                            modifier = Modifier.weight(1f),
                                            onClick = { uriHandler.openUri(link.url) },
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item(key = "app-footer") {
                Box(
                    modifier = Modifier.fillMaxWidth()
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

@Composable
private fun SocialLinkItem(
    link: ResumeSocialLink,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                shape = RoundedCornerShape(12.dp),
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(
                resource = when (link.title) {
                    "Email" -> Res.drawable.gmail
                    "GitHub" -> Res.drawable.ic_github
                    "LinkedIn" -> Res.drawable.linkedin
                    "Telegram" -> Res.drawable.telegram
                    "Instagram" -> Res.drawable.instagram
                    else -> Res.drawable.ic_github
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(30.dp),
        )

        Spacer(Modifier.width(8.dp))

        Text(
            text = link.title,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
private fun ResumeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    val hoverEffect = rememberHoverEffect(enableScale = false)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground,
        )

        Card(
            modifier = Modifier.hoverable(hoverEffect.interactionSource),
            border = BorderStroke(
                width = AppDimensions.BorderThin,
                brush = hoverEffect.borderBrush,
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = content,
            )
        }
    }
}
@Composable
private fun SkillList(skills: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        skills.forEach { skill ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                ),
            ) {
                Text(
                    text = skill,
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 8.dp,
                    ),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.W400,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}