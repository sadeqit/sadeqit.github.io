package sadeqit.github.io.presentation.screens.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import kotlinx.coroutines.delay
import sadeqit.github.io.presentation.components.AnimatedOutlinedButton
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.theme.AppDimensions
import kotlin.time.Duration.Companion.milliseconds

private const val HeroTypingSpeed = 45L
private const val HeroDeletingSpeed = 25L
private const val HeroTypingPause = 1400L
private const val HeroDeletingPause = 500L

private val heroCodeLines = listOf(
    "class" to " Developer",
    "val" to " stack = listOf(",
    "\"Kotlin\"" to ",",
    "\"Android\"" to ",",
    "\"Compose\"" to ",",
    "\"KMP\"" to ",",
    ")" to ""
)

private val heroCodeText = heroCodeLines
    .joinToString("\n") { (first, second) ->
        first + second
    }

@Composable
fun HomeHero(
    isMobile: Boolean,
    onProjectsClick: () -> Unit,
    onContactClick: () -> Unit,
) {
    HomeContainer(
        modifier = Modifier.padding(
            vertical = if (isMobile) {
                AppDimensions.Space16
            } else {
                AppDimensions.Space32
            }
        )
    ) {
        if (isMobile) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(
                    AppDimensions.Space8
                )
            ) {
                HomeReveal {
                    HeroText(
                        centered = true,
                        onProjectsClick = onProjectsClick,
                        onContactClick = onContactClick
                    )
                }

                HomeReveal {
                    HeroCodeCard()
                }
            }
        } else {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    AppDimensions.Space64
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f)
                ) {
                    HomeReveal {
                        HeroText(
                            centered = false,
                            onProjectsClick = onProjectsClick,
                            onContactClick = onContactClick
                        )
                    }
                }

                Box(
                    modifier = Modifier.weight(0.9f)
                ) {
                    HomeReveal {
                        HeroCodeCard()
                    }
                }
            }
        }
    }
}

@Composable
private fun HeroText(
    centered: Boolean,
    onProjectsClick: () -> Unit,
    onContactClick: () -> Unit,
) {
    val hoverEffect = rememberHoverEffect(
        enableScale = true,
        scale = 1.04f
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (centered) {
            Alignment.CenterHorizontally
        } else {
            Alignment.Start
        },
        verticalArrangement = Arrangement.spacedBy(
            AppDimensions.Space20
        )
    ) {
        Text(
            text = "سلام من صادق هستم؛\nبرنامه نویس اندروید.",
            style = if (centered) {
                MaterialTheme.typography.headlineLarge
            } else {
                MaterialTheme.typography.displayLarge
            },
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = if (centered) {
                TextAlign.Center
            } else {
                TextAlign.Start
            }
        )

        Text(
            text = "توسعه دهنده نرم افزارهای اندرویدی با Kotlin و Jetpack Compose؛\n" +
                    "فعال در حوزه توسعه نرم افزارهای چندسکویی با Kotlin Multiplatform.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = if (centered) {
                TextAlign.Center
            } else {
                TextAlign.Start
            }
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                AppDimensions.Space12
            )
        ) {
            HomeRevealItem(
                index = 0,
                isMobile = centered
            ) {
                Button(
                    onClick = onProjectsClick,
                    modifier = Modifier.graphicsLayer {
                        scaleX = hoverEffect.scale
                        scaleY = hoverEffect.scale
                    },
                    interactionSource = hoverEffect.interactionSource,
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("پروژه‌ های من")
                }
            }

            HomeRevealItem(
                index = 1,
                isMobile = centered
            ) {
                AnimatedOutlinedButton(
                    onClick = onContactClick
                ) {
                    Text("تماس با من")
                }
            }
        }

    }
}

@Composable
private fun HeroCodeCard() {
    var typedCharacters by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(Unit) {
        while (true) {
            for (count in 0..heroCodeText.length) {
                typedCharacters = count
                delay(HeroTypingSpeed.milliseconds)
            }

            delay(HeroTypingPause.milliseconds)

            for (count in heroCodeText.length downTo 0) {
                typedCharacters = count
                delay(HeroDeletingSpeed.milliseconds)
            }

            delay(HeroDeletingPause.milliseconds)
        }
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(AppDimensions.Space24),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimensions.Space20),
            verticalArrangement = Arrangement.spacedBy(
                AppDimensions.Space16
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        AppDimensions.Space8
                    )
                ) {
                    WindowDot(MaterialTheme.colorScheme.error)
                    WindowDot(MaterialTheme.colorScheme.tertiary)
                    WindowDot(MaterialTheme.colorScheme.primary)
                }

                Spacer(
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "Sadegh IT",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant
            )

            AnimatedCodeBlock(
                typedCharacters = typedCharacters
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    AppDimensions.Space8
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SkillChip("Kotlin")
                SkillChip("Android")
                SkillChip("Compose")
                SkillChip("KMP")
            }
        }
    }
}

@Composable
private fun AnimatedCodeBlock(
    typedCharacters: Int,
) {
    val cursorTransition = rememberInfiniteTransition(
        label = "heroCodeCursor"
    )

    val cursorAlpha by cursorTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "heroCodeCursorAlpha"
    )

    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Ltr
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(AppDimensions.Space16)
                )
                .background(
                    MaterialTheme.colorScheme.surfaceVariant
                )
                .padding(AppDimensions.Space20),
            verticalArrangement = Arrangement.spacedBy(
                AppDimensions.Space8
            )
        ) {
            var currentIndex = 0

            heroCodeLines.forEachIndexed { index, (first, second) ->
                val lineLength = first.length + second.length

                val visibleCharacters = (
                        typedCharacters - currentIndex
                        ).coerceIn(
                        minimumValue = 0,
                        maximumValue = lineLength
                    )

                val visibleFirstCharacters = visibleCharacters
                    .coerceAtMost(first.length)

                val visibleSecondCharacters = (
                        visibleCharacters - first.length
                        ).coerceAtLeast(0)

                val visibleFirst = first.take(
                    visibleFirstCharacters
                )

                val visibleSecond = second.take(
                    visibleSecondCharacters
                )

                val cursorPosition = typedCharacters - currentIndex

                val showCursor = cursorPosition in 0..lineLength

                CodeLine(
                    first = visibleFirst,
                    second = visibleSecond,
                    showCursor = showCursor,
                    cursorAlpha = cursorAlpha
                )

                currentIndex += lineLength

                if (index < heroCodeLines.lastIndex) {
                    currentIndex += 1
                }
            }
        }
    }
}

@Composable
private fun WindowDot(
    color: Color,
) {
    Box(
        modifier = Modifier
            .width(AppDimensions.IconSmall)
            .height(AppDimensions.IconSmall)
            .clip(CircleShape)
            .background(
                color.copy(alpha = 0.8f)
            )
    )
}

@Composable
private fun CodeLine(
    first: String,
    second: String,
    showCursor: Boolean,
    cursorAlpha: Float,
) {
    Row {
        Text(
            text = first,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = second,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        if (showCursor) {
            Text(
                text = "▌",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary.copy(
                    alpha = cursorAlpha
                )
            )
        }
    }
}