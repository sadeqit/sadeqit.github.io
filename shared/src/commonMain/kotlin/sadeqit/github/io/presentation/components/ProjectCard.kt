package sadeqit.github.io.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import sadeqit.github.io.domain.model.Project
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

    val hoverEffect = rememberHoverEffect(
        enableScale = false
    )

    val projectImage = when (project.thumbnail) {
        "weatherino.png" -> painterResource(Res.drawable.weatherino)
        "dream.png" -> painterResource(Res.drawable.dream)
        else -> null
    }

    Card(
        modifier = modifier
            .height(500.dp)
            .hoverable(hoverEffect.interactionSource),
        border = BorderStroke(
            width = AppDimensions.BorderThin,
            brush = hoverEffect.borderBrush
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(AppDimensions.Space16)
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
                        project.technologies
                            .take(2)
                            .forEach { technology ->
                                ProjectTechnologyChip(technology)
                            }
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

                // Footer
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
private fun ProjectTechnologyChip(
    technology: String
) {
    val (backgroundColor, textColor) = when (technology.lowercase()) {
        "kotlin" -> Color(0x147F52FF) to Color(0xFF9B78F5)

        "kotlin multiplatform" -> Color(0x146D28D9) to Color(0xFFA185E3)

        "compose multiplatform",
        "jetpack compose" -> Color(0x140284C7) to Color(0xFF38A3D5)

        "ktor" -> Color(0x140369A1) to Color(0xFF398DBA)

        "koin" -> Color(0x14B45309) to Color(0xFFC58A48)

        "sqldelight" -> Color(0x1415803D) to Color(0xFF55A875)

        "android" -> Color(0x1416803D) to Color(0xFF55A875)

        "room" -> Color(0x14C2410C) to Color(0xFFC77B54)

        "hilt" -> Color(0x14BE185D) to Color(0xFFC56A98)

        "datastore" -> Color(0x144338CA) to Color(0xFF777DD1)

        else -> MaterialTheme.colorScheme.primary.copy(alpha = 0.08f) to
                MaterialTheme.colorScheme.primary
    }

    Text(
        text = technology,
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


