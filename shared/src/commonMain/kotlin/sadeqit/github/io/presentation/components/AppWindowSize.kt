package sadeqit.github.io.presentation.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import sadeqit.github.io.presentation.theme.AppBreakpoints

enum class AppWindowSize {
    Mobile,
    Desktop
}

@Composable
fun AppWindowSize(
    content: @Composable (AppWindowSize) -> Unit
) {
    BoxWithConstraints {
        val windowSize = if (maxWidth < AppBreakpoints.Mobile) {
            AppWindowSize.Mobile
        } else {
            AppWindowSize.Desktop
        }

        content(windowSize)
    }
}