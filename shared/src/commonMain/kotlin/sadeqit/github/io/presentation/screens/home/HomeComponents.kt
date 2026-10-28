package sadeqit.github.io.presentation.screens.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onVisibilityChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import sadeqit.github.io.presentation.theme.AppBreakpoints
import sadeqit.github.io.presentation.theme.AppDimensions

private const val HomeAnimationDuration = 600
private const val HomeAnimationStagger = 100


@Composable
fun HomeReveal(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    var hasEnteredViewport by remember {
        mutableStateOf(false)
    }

    val animationProgress by animateFloatAsState(
        targetValue = if (hasEnteredViewport) 1f else 0f,
        animationSpec = tween(
            durationMillis = HomeAnimationDuration,
            easing = FastOutSlowInEasing
        ),
        label = "homeReveal"
    )

    Box(
        modifier = modifier
            .onVisibilityChanged(
                minFractionVisible = 0.2f
            ) { visible ->
                if (visible) {
                    hasEnteredViewport = true
                }
            }
            .graphicsLayer {
                alpha = animationProgress
                translationY = -(1f - animationProgress) * 32.dp.toPx()
            }
    ) {
        content()
    }
}

@Composable
fun HomeRevealItem(
    index: Int,
    isMobile: Boolean,
    modifier: Modifier = Modifier,
    isVisible: Boolean? = null,
    content: @Composable () -> Unit,
) {
    var hasEnteredViewport by remember {
        mutableStateOf(false)
    }

    val shouldAnimate = isVisible ?: hasEnteredViewport

    val animationProgress by animateFloatAsState(
        targetValue = if (shouldAnimate) 1f else 0f,
        animationSpec = tween(
            durationMillis = HomeAnimationDuration,
            delayMillis = index * HomeAnimationStagger,
            easing = FastOutSlowInEasing
        ),
        label = "homeRevealItem"
    )

    Box(
        modifier = modifier
            .then(
                if (isVisible == null) {
                    Modifier.onVisibilityChanged(
                        minFractionVisible = 0.2f
                    ) { visible ->
                        if (visible) {
                            hasEnteredViewport = true
                        }
                    }
                } else {
                    Modifier
                }
            )
            .graphicsLayer {
                alpha = animationProgress

                if (isMobile) {
                    val direction = if (index % 2 == 0) 1f else -1f

                    translationX =
                        (1f - animationProgress) * direction * 64.dp.toPx()
                } else {
                    translationY =
                        -(1f - animationProgress) * 28.dp.toPx()
                }
            }
    ) {
        content()
    }
}

@Composable
fun HomeContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxWidth()
    ) {
        val isMobile = maxWidth < AppBreakpoints.Mobile

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = if (isMobile) {
                        AppDimensions.Space12
                    } else {
                        AppDimensions.ContentPadding
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = AppDimensions.ContentMaxWidth)
            ) {
                content()
            }
        }
    }
}

@Composable
fun SectionHeader(
    eyebrow: String,
    title: String,
    description: String,
    centered: Boolean = false,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (centered) {
            Alignment.CenterHorizontally
        } else {
            Alignment.Start
        },
        verticalArrangement = Arrangement.spacedBy(AppDimensions.Space12)
    ) {
        Text(
            text = eyebrow,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textAlign = if (centered) {
                TextAlign.Center
            } else {
                TextAlign.Start
            }
        )

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = if (centered) {
                TextAlign.Center
            } else {
                TextAlign.Start
            }
        )

        Text(
            text = description,
            modifier = Modifier.widthIn(max = 720.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = if (centered) {
                TextAlign.Center
            } else {
                TextAlign.Start
            }
        )
    }
}

@Composable
fun HorizontalCardRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onHorizontalDrag = { change, dragAmount ->
                        change.consume()

                        scope.launch {
                            scrollState.scrollBy(dragAmount)
                        }
                    }
                )
            },
        horizontalArrangement = Arrangement.spacedBy(
            AppDimensions.Space16
        ),
        content = content
    )
}