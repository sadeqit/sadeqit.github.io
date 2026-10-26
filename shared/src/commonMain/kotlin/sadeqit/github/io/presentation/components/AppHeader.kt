package sadeqit.github.io.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import sadeqit.github.io.presentation.navigation.AppRoute
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.github.io.presentation.theme.AppThemeMode

@Composable
fun AppHeader(
    currentRoute: AppRoute,
    onNavigate: (AppRoute) -> Unit,
    themeMode: AppThemeMode,
    onThemeModeChange: (AppThemeMode) -> Unit
) {
    AppWindowSize { windowSize ->
        when (windowSize) {
            AppWindowSize.Mobile -> {
                MobileHeader(
                    currentRoute = currentRoute,
                    onNavigate = onNavigate,
                    themeMode = themeMode,
                    onThemeModeChange = onThemeModeChange
                )
            }

            AppWindowSize.Desktop -> {
                DesktopHeader(
                    currentRoute = currentRoute,
                    onNavigate = onNavigate,
                    themeMode = themeMode,
                    onThemeModeChange = onThemeModeChange
                )
            }
        }
    }
}

@Composable
private fun MobileHeader(
    currentRoute: AppRoute,
    onNavigate: (AppRoute) -> Unit,
    themeMode: AppThemeMode,
    onThemeModeChange: (AppThemeMode) -> Unit
) {
    var menuExpanded by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppDimensions.ContentPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppLogo()

        TextButton(
            onClick = {
                menuExpanded = true
            }
        ) {
            Text("☰")
        }

        DropdownMenu(
            expanded = menuExpanded,
            onDismissRequest = {
                menuExpanded = false
            }
        ) {
            NavigationMenuItem(
                text = "خانه",
                route = AppRoute.Home,
                currentRoute = currentRoute,
                onNavigate = onNavigate,
                onDismiss = { menuExpanded = false }
            )

            NavigationMenuItem(
                text = "پروژه‌ها",
                route = AppRoute.Projects,
                currentRoute = currentRoute,
                onNavigate = onNavigate,
                onDismiss = { menuExpanded = false }
            )

            NavigationMenuItem(
                text = "مقالات",
                route = AppRoute.Articles,
                currentRoute = currentRoute,
                onNavigate = onNavigate,
                onDismiss = { menuExpanded = false }
            )

            NavigationMenuItem(
                text = "رزومه",
                route = AppRoute.Resume,
                currentRoute = currentRoute,
                onNavigate = onNavigate,
                onDismiss = { menuExpanded = false }
            )

            NavigationMenuItem(
                text = "درباره من",
                route = AppRoute.About,
                currentRoute = currentRoute,
                onNavigate = onNavigate,
                onDismiss = { menuExpanded = false }
            )

            NavigationMenuItem(
                text = "تماس",
                route = AppRoute.Contact,
                currentRoute = currentRoute,
                onNavigate = onNavigate,
                onDismiss = { menuExpanded = false }
            )

            ThemeMenuSection(
                themeMode = themeMode,
                onThemeModeChange = onThemeModeChange,
                onDismiss = { menuExpanded = false }
            )
        }
    }
}

@Composable
private fun DesktopHeader(
    currentRoute: AppRoute,
    onNavigate: (AppRoute) -> Unit,
    themeMode: AppThemeMode,
    onThemeModeChange: (AppThemeMode) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppDimensions.ContentPadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppLogo()

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationItem(
                text = "خانه",
                selected = currentRoute == AppRoute.Home,
                onClick = { onNavigate(AppRoute.Home) }
            )

            NavigationItem(
                text = "پروژه‌ها",
                selected = currentRoute == AppRoute.Projects,
                onClick = { onNavigate(AppRoute.Projects) }
            )

            NavigationItem(
                text = "مقالات",
                selected = currentRoute == AppRoute.Articles,
                onClick = { onNavigate(AppRoute.Articles) }
            )

            NavigationItem(
                text = "رزومه",
                selected = currentRoute == AppRoute.Resume,
                onClick = { onNavigate(AppRoute.Resume) }
            )

            NavigationItem(
                text = "درباره من",
                selected = currentRoute == AppRoute.About,
                onClick = { onNavigate(AppRoute.About) }
            )

            NavigationItem(
                text = "تماس",
                selected = currentRoute == AppRoute.Contact,
                onClick = { onNavigate(AppRoute.Contact) }
            )

            ThemeSelector(
                themeMode = themeMode,
                onThemeModeChange = onThemeModeChange
            )
        }
    }
}

@Composable
private fun NavigationItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick
    ) {
        Text(
            text = if (selected) "• $text" else text
        )
    }
}

@Composable
private fun NavigationMenuItem(
    text: String,
    route: AppRoute,
    currentRoute: AppRoute,
    onNavigate: (AppRoute) -> Unit,
    onDismiss: () -> Unit
) {
    DropdownMenuItem(
        text = {
            Text(text)
        },
        onClick = {
            onNavigate(route)
            onDismiss()
        }
    )
}

@Composable
private fun ThemeMenuSection(
    themeMode: AppThemeMode,
    onThemeModeChange: (AppThemeMode) -> Unit,
    onDismiss: () -> Unit
) {
    DropdownMenuItem(
        text = {
            Text("تم")
        },
        onClick = {}
    )

    DropdownMenuItem(
        text = {
            Text(
                if (themeMode == AppThemeMode.Light) {
                    "✓ روشن"
                } else {
                    "روشن"
                }
            )
        },
        onClick = {
            onThemeModeChange(AppThemeMode.Light)
            onDismiss()
        }
    )

    DropdownMenuItem(
        text = {
            Text(
                if (themeMode == AppThemeMode.Dark) {
                    "✓ تیره"
                } else {
                    "تیره"
                }
            )
        },
        onClick = {
            onThemeModeChange(AppThemeMode.Dark)
            onDismiss()
        }
    )

    DropdownMenuItem(
        text = {
            Text(
                if (themeMode == AppThemeMode.System) {
                    "✓ سیستم"
                } else {
                    "سیستم"
                }
            )
        },
        onClick = {
            onThemeModeChange(AppThemeMode.System)
            onDismiss()
        }
    )
}