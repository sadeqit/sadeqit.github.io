package sadeqit.github.io.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onVisibilityChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeProjects(
    onProjectsClick: () -> Unit,
) {


    HomeContainer(
        modifier = Modifier.padding(
            vertical = AppDimensions.Space48
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                AppDimensions.Space40
            )
        ) {
            HomeReveal {
                SectionHeader(
                    eyebrow = "SELECTED PROJECTS",
                    title = "پروژه‌های منتخب",
                    description = "نمونه‌ای از محصولاتی که با تمرکز روی تجربه کاربری، معماری و کیفیت ساخته شده‌اند."
                )
            }

            HorizontalCardRow{
                HomeRevealItem(
                    index = 0,
                    isMobile = false,

                ) {
                    ProjectCard(
                        modifier = Modifier.width(280.dp),
                        title = "Weatherino",
                        description = "اپلیکیشن هواشناسی مولتی‌پلتفرم با Kotlin Multiplatform و Compose.",
                        tags = listOf("KMP", "Compose", "Ktor"),
                        onClick = onProjectsClick
                    )
                }

                HomeRevealItem(
                    index = 1,
                    isMobile = false,

                ) {
                    ProjectCard(
                        modifier = Modifier.width(280.dp),
                        title = "تعبیر خواب صادق",
                        description = "اپلیکیشن اندرویدی با تمرکز روی تجربه کاربری ساده و سریع.",
                        tags = listOf("Android", "Kotlin", "Compose"),
                        onClick = onProjectsClick
                    )
                }

                HomeRevealItem(
                    index = 2,
                    isMobile = false,

                ) {
                    ProjectCard(
                        modifier = Modifier.width(280.dp),
                        title = "SADEGH IT",
                        description = "وب‌سایت شخصی و حرفه‌ای برای معرفی تجربه، پروژه‌ها و مهارت‌ها.",
                        tags = listOf("Kotlin", "Wasm", "Compose"),
                        onClick = onProjectsClick
                    )
                }
            }

            HomeReveal {
                OutlinedButton(
                    onClick = onProjectsClick,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("مشاهده همه پروژه‌ها")
                }
            }
        }
    }
}

@Composable
private fun ProjectCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    tags: List<String>,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(AppDimensions.Space16),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(AppDimensions.Space20),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space16)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppDimensions.Space96 + AppDimensions.Space24)
                    .clip(RoundedCornerShape(AppDimensions.Space12))
                    .background(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.07f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "</>",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.65f),
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(AppDimensions.Space8),
                verticalArrangement = Arrangement.spacedBy(AppDimensions.Space8)
            ) {
                tags.forEach { SkillChip(it) }
            }
        }
    }
}
