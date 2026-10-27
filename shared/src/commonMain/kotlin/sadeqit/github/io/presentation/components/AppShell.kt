package sadeqit.github.io.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
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

            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = maxHeight)
                        .verticalScroll(rememberScrollState())
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .widthIn(max = AppDimensions.ContentMaxWidth)
                            .padding(
                                horizontal = AppDimensions.ContentPadding
                            )
                    ) {
                        CompositionLocalProvider(
                            LocalLayoutDirection provides LayoutDirection.Rtl
                        ) {
                            content()
                        }
                    }

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )

                    AppFooter()
                }
            }
        }
    }
}