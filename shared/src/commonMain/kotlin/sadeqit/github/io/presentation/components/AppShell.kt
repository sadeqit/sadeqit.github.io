package sadeqit.github.io.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import sadeqit.github.io.presentation.navigation.AppRoute
import sadeqit.github.io.presentation.theme.AppThemeMode

@Composable
fun AppShell(
    currentRoute: AppRoute,
    onNavigate: (AppRoute) -> Unit,
    themeMode: AppThemeMode,
    onThemeModeChange: (AppThemeMode) -> Unit,
    content: @Composable () -> Unit
) {
    AppBackground {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AppHeader(
                currentRoute = currentRoute,
                onNavigate = onNavigate,
                themeMode = themeMode,
                onThemeModeChange = onThemeModeChange
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                CompositionLocalProvider(
                    LocalLayoutDirection provides LayoutDirection.Rtl
                ) {
                    content()
                }
            }

        }
    }
}