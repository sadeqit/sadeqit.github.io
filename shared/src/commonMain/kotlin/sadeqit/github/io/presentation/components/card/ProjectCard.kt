package sadeqit.github.io.presentation.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.domain.model.ProjectReleaseType
import sadeqit.github.io.domain.model.ProjectType
import sadeqit.github.io.presentation.theme.AppColors
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.dream
import sadeqit.shared.generated.resources.ic_bazar
import sadeqit.shared.generated.resources.ic_github
import sadeqit.shared.generated.resources.weatherino

@Composable
fun ProjectCard(
    modifier: Modifier = Modifier,
    project: Project,
    onClick: () -> Unit,
) {
    val uriHandler = LocalUriHandler.current

    val projectImage = when (project.thumbnail) {
        "weatherino.png" -> painterResource(Res.drawable.weatherino)
        "dream.png" -> painterResource(Res.drawable.dream)
        else -> null
    }

    HoverCard(
        modifier = modifier.height(500.dp),
        shape = RoundedCornerShape(AppDimensions.Space16),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Project Image
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(
                        RoundedCornerShape(
                            topStart = AppDimensions.Space16,
                            topEnd = AppDimensions.Space16
                        )
                    )
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                if (projectImage != null) {
                    Image(
                        painter = projectImage,
                        contentDescription = project.title,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(AppDimensions.Space20)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        AppDimensions.Space12
                    )
                ) {
                    // Project Technologies
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(
                            AppDimensions.Space8
                        ),
                        verticalArrangement = Arrangement.spacedBy(
                            AppDimensions.Space8
                        )
                    ) {
                        ProjectTypeChip(project.projectType)
                        ProjectReleaseChip(project.releaseType)
                    }
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant
                    )
                    // Project Title
                    Text(
                        text = project.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    // Project Description
                    Text(
                        text = project.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,

                        )
                }

                Spacer(modifier = Modifier.weight(1f))

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outlineVariant
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = AppDimensions.Space8),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // GitHub
                    project.githubUrl?.let { url ->
                        IconButton(
                            onClick = {
                                uriHandler.openUri(url)
                            }
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.ic_github),
                                contentDescription = "GitHub",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    // Cafe Bazaar
                    project.appUrl?.let { url ->
                        IconButton(
                            onClick = {
                                uriHandler.openUri(url)
                            }
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.ic_bazar),
                                contentDescription = "Cafe Bazaar",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    // Project Details
                    TextButton(
                        onClick = onClick
                    ) {
                        Text("مشاهده پروژه")

                        Spacer(
                            modifier = Modifier.width(AppDimensions.Space8)
                        )

                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                            contentDescription = "مشاهده جزئیات"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProjectTypeChip(type: ProjectType) {
    val isDark = MaterialTheme.colorScheme.background == AppColors.DarkBackground

    val (label, backgroundColor, textColor) = when (type) {
        ProjectType.Android -> Triple(
            "Android",
            AppColors.ProjectAndroidBackground,
            if (isDark) AppColors.ProjectAndroidDark else AppColors.ProjectAndroid
        )

        ProjectType.KMP -> Triple(
            "KMP",
            AppColors.ProjectKmpBackground,
            if (isDark) AppColors.ProjectKmpDark else AppColors.ProjectKmp
        )
    }

    ProjectInfoChip(label, backgroundColor, textColor)
}

@Composable
fun ProjectReleaseChip(type: ProjectReleaseType) {
    val isDark = MaterialTheme.colorScheme.background == AppColors.DarkBackground

    val (label, backgroundColor, textColor) = when (type) {
        ProjectReleaseType.Released -> Triple(
            "Released",
            AppColors.ProjectReleasedBackground,
            if (isDark) AppColors.ProjectReleasedDark else AppColors.ProjectReleased
        )

        ProjectReleaseType.SourceCode -> Triple(
            "Source Code",
            AppColors.ProjectSourceCodeBackground,
            if (isDark) AppColors.ProjectSourceCodeDark else AppColors.ProjectSourceCode
        )
    }

    ProjectInfoChip(label, backgroundColor, textColor)
}

@Composable
fun ProjectInfoChip(
    label: String,
    backgroundColor: Color,
    textColor: Color
) {
    Text(
        text = label,
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(AppDimensions.Space8)
            )
            .padding(
                horizontal = AppDimensions.Space12,
                vertical = AppDimensions.Space8
            ),
        style = MaterialTheme.typography.labelMedium,
        fontWeight = FontWeight.Bold,
        color = textColor,
        maxLines = 1
    )
}


