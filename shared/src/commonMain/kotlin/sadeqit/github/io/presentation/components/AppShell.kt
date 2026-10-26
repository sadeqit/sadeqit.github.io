package sadeqit.github.io.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import sadeqit.github.io.presentation.navigation.AppRoute
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.github.io.presentation.theme.AppThemeMode

@Composable
fun AppShell(
    currentRoute: AppRoute,
    onNavigate: (AppRoute) -> Unit,
    themeMode: AppThemeMode,
    onThemeModeChange: (AppThemeMode) -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
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
                .weight(1f),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .widthIn(max = AppDimensions.ContentMaxWidth)
                    .padding(horizontal = AppDimensions.ContentPadding)
            ) {
                content()
            }
        }

        AppFooter()
    }
}