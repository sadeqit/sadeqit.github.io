package sadeqit.github.io.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun AppFooter() {
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "© 2026 SADEGH IT",
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimensions.ContentPadding),
            style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
}