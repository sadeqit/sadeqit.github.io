package sadeqit.github.io

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import sadeqit.github.io.presentation.navigation.AppNavigation
import sadeqit.github.io.presentation.theme.AppTheme
import sadeqit.github.io.presentation.theme.AppThemeMode
import sadeqit.github.io.presentation.theme.ThemeStorage

@Composable
fun App() {
    var themeMode by remember {
        mutableStateOf(
            ThemeStorage.load() ?: AppThemeMode.Dark
        )
    }

    AppTheme(
        themeMode = themeMode
    ) {
        AppNavigation(
            themeMode = themeMode,
            onThemeModeChange = { newThemeMode ->
                themeMode = newThemeMode
                ThemeStorage.save(newThemeMode)
            }
        )
    }
}