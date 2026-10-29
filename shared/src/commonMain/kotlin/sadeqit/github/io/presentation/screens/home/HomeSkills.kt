package sadeqit.github.io.presentation.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeSkills(
    isMobile: Boolean,
) {
    HomeContainer(
        modifier = Modifier.padding(
            vertical = AppDimensions.Space48
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space32)
        ) {
            HomeReveal {
                SectionHeader(
                    eyebrow = "TECH STACK",
                    title = "تکنولوژی هایی که با آن ها کار می کنم",
                    description = "مجموعه ای از ابزارهایی که در ساخت و توسعه پروژه‌هایم استفاده می‌ کنم."
                )
            }

            SkillsContent(
                isMobile = isMobile
            )
        }
    }
}

@Composable
private fun SkillsContent(
    isMobile: Boolean,
) {
    val skills = listOf(
        "Language & Concurrency" to "Kotlin • Coroutines • Flow • Kotlin Serialization",
        "Android" to "Android SDK • Jetpack Compose • Material 3 • Navigation Compose",
        "Multiplatform" to "Kotlin Multiplatform • Compose Multiplatform • Kotlin/Wasm",
        "Architecture" to "MVVM • Clean Architecture • SOLID • Design Patterns • Clean Code",
        "Networking" to "Ktor • Retrofit • REST APIs",
        "Data" to "Room • DataStore • SQLDelight",
        "Dependency Injection" to "Dagger Hilt • Koin",
        "UI/UX" to "Material Design • Responsive Design • Light/Dark Theme • Animation & Motion",
        "Tools" to "Git • GitHub • Git Flow • CI-CD"
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(AppDimensions.Space12)
    ) {
        skills.chunked(if (isMobile) 1 else 3).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    AppDimensions.Space12
                )
            ) {
                row.forEach { (title, items) ->
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        HomeReveal {
                            SkillGroup(
                                modifier = Modifier.fillMaxWidth(),
                                title = title,
                                items = items
                            )
                        }
                    }
                }

                if (row.size == 1 && !isMobile) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun SkillGroup(
    modifier: Modifier = Modifier,
    title: String,
    items: String,
) {
    val hoverEffect = rememberHoverEffect(
        enableScale = false
    )

    Card(
        modifier = modifier
            .hoverable(hoverEffect.interactionSource),
        border = BorderStroke(
            width = AppDimensions.BorderThin,
            brush = hoverEffect.borderBrush
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
    ) {
        Column(
            modifier = Modifier.padding(AppDimensions.Space16),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space8)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = items,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun SkillChip(
    text: String,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(AppDimensions.Space8))
            .background(
                MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
            )
            .border(
                width = AppDimensions.BorderThin,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
                shape = RoundedCornerShape(AppDimensions.Space8)
            )
            .padding(
                horizontal = AppDimensions.Space12,
                vertical = AppDimensions.Space8
            )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold
        )
    }
}
