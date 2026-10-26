package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun ArticlesScreen() {
    Text(
        text = "Articles",
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimensions.ContentPadding)
    )
}