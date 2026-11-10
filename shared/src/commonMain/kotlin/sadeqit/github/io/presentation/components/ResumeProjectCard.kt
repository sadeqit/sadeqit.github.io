package sadeqit.github.io.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import sadeqit.github.io.domain.model.ResumeProject
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.ic_bazar
import sadeqit.shared.generated.resources.ic_github

@Composable
fun ResumeProjectCard(
    project: ResumeProject,
    onGithubClick: () -> Unit,
    onAppClick: () -> Unit,
    onDetailsClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        shape = RoundedCornerShape(12.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimensions.Space20),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space16),
        ) {
            Text(
                text = project.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )

            Text(
                text = project.description,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant,
            )
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
            ) {
                project.technologies.forEach { technology ->
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        ),
                    ) {
                        Text(
                            text = technology,
                            modifier = Modifier.padding(
                                horizontal = AppDimensions.Space12,
                                vertical = AppDimensions.Space8,
                            ),
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.W400,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                }
            }

            if (
                project.githubUrl != null ||
                project.appUrl != null ||
                project.projectId != null
            ) {
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outlineVariant,
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    project.githubUrl?.let {
                        TextButton(
                            onClick = onGithubClick,
                            contentPadding = PaddingValues(horizontal = AppDimensions.Space8),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
                            ) {
                                Image(
                                    painter = painterResource(Res.drawable.ic_github),
                                    contentDescription = "GitHub",
                                    modifier = Modifier.size(30.dp),
                                )
                                Text("گیت هاب")
                            }
                        }
                    }

                    project.appUrl?.let {
                        TextButton(
                            onClick = onAppClick,
                            contentPadding = PaddingValues(horizontal = AppDimensions.Space8),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
                            ) {
                                Image(
                                    painter = painterResource(Res.drawable.ic_bazar),
                                    contentDescription = "Cafe Bazaar",
                                    modifier = Modifier.size(30.dp),
                                )
                                Text("کافه‌ بازار")
                            }
                        }
                    }

                    Spacer(Modifier.weight(1f))

                    project.projectId?.let {
                        TextButton(onClick = onDetailsClick) {
                            Text("جزئیات")
                            Spacer(Modifier.width(AppDimensions.Space8))
                            Icon(
                                Icons.AutoMirrored.Rounded.ArrowForward,
                                contentDescription = null,
                            )
                        }
                    }
                }
            }
        }
    }
}