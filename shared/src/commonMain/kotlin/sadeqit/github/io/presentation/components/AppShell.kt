package sadeqit.github.io.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import sadeqit.github.io.presentation.navigation.AppRoute

@Composable
fun AppShell(
    currentRoute: AppRoute,
    onNavigate: (AppRoute) -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppHeader(
            currentRoute = currentRoute,
            onNavigate = onNavigate
        )

        content()

        AppFooter()
    }
}