package sadeqit.github.io.presentation.components

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import sadeqit.github.io.presentation.theme.AppThemeMode

@Composable
fun ThemeSelector(
    themeMode: AppThemeMode,
    onThemeModeChange: (AppThemeMode) -> Unit
) {
    var menuExpanded by remember {
        mutableStateOf(false)
    }

    TextButton(
        onClick = {
            menuExpanded = true
        }
    ) {
        Text("تم")
    }

    DropdownMenu(
        expanded = menuExpanded,
        onDismissRequest = {
            menuExpanded = false
        }
    ) {
        ThemeMenuItem(
            text = "روشن",
            selected = themeMode == AppThemeMode.Light,
            onClick = {
                onThemeModeChange(AppThemeMode.Light)
                menuExpanded = false
            }
        )

        ThemeMenuItem(
            text = "تیره",
            selected = themeMode == AppThemeMode.Dark,
            onClick = {
                onThemeModeChange(AppThemeMode.Dark)
                menuExpanded = false
            }
        )

        ThemeMenuItem(
            text = "سیستم",
            selected = themeMode == AppThemeMode.System,
            onClick = {
                onThemeModeChange(AppThemeMode.System)
                menuExpanded = false
            }
        )
    }
}

@Composable
private fun ThemeMenuItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    DropdownMenuItem(
        text = {
            Text(
                text = if (selected) "✓ $text" else text
            )
        },
        onClick = onClick
    )
}