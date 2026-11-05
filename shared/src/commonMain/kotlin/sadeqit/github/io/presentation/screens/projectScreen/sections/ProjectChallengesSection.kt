package sadeqit.github.io.presentation.screens.projectScreen.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.screens.projectScreen.components.ChallengeCard
import sadeqit.github.io.presentation.screens.projectScreen.components.ProjectSection
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun ProjectChallengesSection(
    project: Project,
    isMobile: Boolean
) {
    if (project.challenges.isEmpty()) return

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
}}