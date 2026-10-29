package sadeqit.github.io.presentation.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun rememberHoverEffect(
    enableScale: Boolean = false,
    scale: Float = 1.03f,
    borderDurationMillis: Int = 5000,
): HoverEffect {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val isHovered by interactionSource.collectIsHoveredAsState()

    val animatedScale by animateFloatAsState(
        targetValue = if (enableScale && isHovered) {
            scale
        } else {
            1f
        },
        animationSpec = tween(
            durationMillis = 180,
            easing = FastOutSlowInEasing
        ),
        label = "hoverScale"
    )

    val borderBrush = animatedBorderBrush(
        isHovered = isHovered,
        durationMillis = borderDurationMillis
    )

    return HoverEffect(
        interactionSource = interactionSource,
        scale = animatedScale,
        borderBrush = borderBrush,
    )
}

class HoverEffect internal constructor(
    val interactionSource: MutableInteractionSource,
    val scale: Float,
    val borderBrush: Brush,
) {
    fun modifier(): Modifier =
        Modifier
            .hoverable(interactionSource)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
}