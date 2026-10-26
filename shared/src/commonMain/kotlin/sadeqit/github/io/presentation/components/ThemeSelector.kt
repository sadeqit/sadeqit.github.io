package sadeqit.github.io.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import kotlinx.coroutines.delay
import sadeqit.github.io.presentation.theme.AppThemeMode
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun ThemeSelector(
    themeMode: AppThemeMode,
    onThemeModeChange: (AppThemeMode) -> Unit
) {
    val solarRotation = rememberInfiniteTransition(
        label = "SolarRotation"
    )

    val sunRotation by solarRotation.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 12000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "SunRotation"
    )

    val moonRotation = remember {
        Animatable(0f)
    }

    LaunchedEffect(themeMode) {
        if (themeMode == AppThemeMode.Dark) {
            moonRotation.snapTo(0f)

            while (true) {
                delay(3000.milliseconds)

                moonRotation.animateTo(
                    targetValue = 360f,
                    animationSpec = tween(
                        durationMillis = 1000,
                        easing = LinearEasing
                    )
                )

                moonRotation.snapTo(0f)
            }
        } else {
            moonRotation.snapTo(0f)
        }
    }

    val rotation = when (themeMode) {
        AppThemeMode.Light -> sunRotation
        AppThemeMode.Dark -> moonRotation.value
    }

    TextButton(
        modifier = Modifier.semantics {
            contentDescription = "تغییر تم"
        },
        onClick = {
            onThemeModeChange(
                when (themeMode) {
                    AppThemeMode.Light -> AppThemeMode.Dark
                    AppThemeMode.Dark -> AppThemeMode.Light
                }
            )
        }
    ) {
        Text(
            text = when (themeMode) {
                AppThemeMode.Light -> "☀️"
                AppThemeMode.Dark -> "🌙"
            },
            modifier = Modifier.graphicsLayer {
                rotationZ = rotation
            },
            style = MaterialTheme.typography.titleMedium
        )
    }
}