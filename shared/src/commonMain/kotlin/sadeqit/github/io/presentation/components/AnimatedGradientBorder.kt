package sadeqit.github.io.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp

@Composable
fun animatedBorderBrush(
    isHovered: Boolean,
    durationMillis: Int = 5000,
): Brush {
    val transition = rememberInfiniteTransition(
        label = "animatedBorder"
    )

    val progress by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "borderRotation"
    )

    val colors = listOf(
        Color(0xFF60A5FA),
        Color(0xFF818CF8),
        Color(0xFFA78BFA),
        Color(0xFFEC4899),
        Color(0xFFF472B6),
        Color(0xFF34D399),
        Color(0xFF22D3EE)
    )

    if (!isHovered) {
        return Brush.linearGradient(
            colors = listOf(
                Color.Transparent,
                Color.Transparent
            )
        )
    }

    val stops = List(colors.size + 1) { index ->
        val position = index.toFloat() / colors.size
        val shifted = (position + progress) % 1f

        val scaled = shifted * colors.size
        val lowerIndex = scaled.toInt()
        val fraction = scaled - lowerIndex

        val startColor = colors[lowerIndex]
        val endColor = colors[
            (lowerIndex + 1) % colors.size
        ]

        position to lerp(
            start = startColor,
            stop = endColor,
            fraction = fraction
        )
    }

    return Brush.sweepGradient(
        colorStops = stops.toTypedArray()
    )
}