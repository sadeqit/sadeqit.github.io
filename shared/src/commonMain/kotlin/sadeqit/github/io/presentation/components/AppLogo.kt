package sadeqit.github.io.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun AppLogo() {
    Text(
        text = "SADEGH IT",
        style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
}