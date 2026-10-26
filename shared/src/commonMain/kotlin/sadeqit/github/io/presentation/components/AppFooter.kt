package sadeqit.github.io.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AppFooter() {
    Text(
        text = "© 2026 SADEGH IT",
        style = androidx.compose.material3.MaterialTheme.typography.bodySmall,
        textAlign = TextAlign.Center
    )
}