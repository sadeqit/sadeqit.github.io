package sadeqit.github.io.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme

@Composable
fun AppBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val background = MaterialTheme.colorScheme.background
    val primary = MaterialTheme.colorScheme.primary
    val accent = MaterialTheme.colorScheme.tertiary

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        background,
                        background.copy(alpha = 0.96f)
                    )
                )
            )
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            // ظریف‌ترین لایه Grid
            val gridSize = 40f
            val gridColor = primary.copy(alpha = 0.035f)

            var x = 0f
            while (x <= size.width) {
                drawLine(
                    color = gridColor,
                    start = Offset(x, 0f),
                    end = Offset(x, size.height)
                )
                x += gridSize
            }

            var y = 0f
            while (y <= size.height) {
                drawLine(
                    color = gridColor,
                    start = Offset(0f, y),
                    end = Offset(size.width, y)
                )
                y += gridSize
            }

            // Glow آبی
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        primary.copy(alpha = 0.08f),
                        Color.Transparent
                    )
                ),
                radius = size.width * 0.45f,
                center = Offset(
                    x = size.width * 0.15f,
                    y = size.height * 0.12f
                )
            )

            // Glow سبز
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        accent.copy(alpha = 0.05f),
                        Color.Transparent
                    )
                ),
                radius = size.width * 0.35f,
                center = Offset(
                    x = size.width * 0.9f,
                    y = size.height * 0.8f
                )
            )
        }

        content()
    }
}