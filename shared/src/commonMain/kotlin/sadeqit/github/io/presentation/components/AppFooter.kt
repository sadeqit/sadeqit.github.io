package sadeqit.github.io.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun AppFooter() {
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = AppDimensions.ContentMaxWidth)
                .padding(AppDimensions.ContentPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "© 2026 SADEGH IT",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}