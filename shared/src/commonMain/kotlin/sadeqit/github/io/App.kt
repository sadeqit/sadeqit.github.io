package sadeqit.github.io

import androidx.compose.runtime.Composable
import sadeqit.github.io.presentation.navigation.AppNavigation
import sadeqit.github.io.presentation.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        AppNavigation()
    }
}