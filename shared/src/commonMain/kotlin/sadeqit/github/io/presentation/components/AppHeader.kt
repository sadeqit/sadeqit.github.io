package sadeqit.github.io.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface
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
}

@Composable
private fun MobileHeader(
    currentRoute: AppRoute,
    onNavigate: (AppRoute) -> Unit,
    themeMode: AppThemeMode,
    onThemeModeChange: (AppThemeMode) -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = AppDimensions.ContentPadding,

                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                MobileMenuButton(
                    expanded = menuExpanded,
                    onClick = {
                        menuExpanded = !menuExpanded
                    }
                )

                ThemeSelector(
                    themeMode = themeMode,
                    onThemeModeChange = onThemeModeChange
                )
            }

            AppLogo()
        }

        AnimatedVisibility(
            visible = menuExpanded,
            modifier = Modifier.fillMaxWidth(),
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(
                        horizontal = AppDimensions.ContentPadding,
                        vertical = AppDimensions.Space24
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    AppDimensions.Space16
                )
            ) {
                MobileNavigationItem(
                    text = "خانه",
                    route = AppRoute.Home,
                    currentRoute = currentRoute,
                    onNavigate = onNavigate,
                    onDismiss = {
                        menuExpanded = false
                    }
                )

                MobileNavigationItem(
                    text = "پروژه‌ها",
                    route = AppRoute.Projects,
                    currentRoute = currentRoute,
                    onNavigate = onNavigate,
                    onDismiss = {
                        menuExpanded = false
                    }
                )

                MobileNavigationItem(
                    text = "مقالات",
                    route = AppRoute.Articles,
                    currentRoute = currentRoute,
                    onNavigate = onNavigate,
                    onDismiss = {
                        menuExpanded = false
                    }
                )

                MobileNavigationItem(
                    text = "رزومه",
                    route = AppRoute.Resume,
                    currentRoute = currentRoute,
                    onNavigate = onNavigate,
                    onDismiss = {
                        menuExpanded = false
                    }
                )

                MobileNavigationItem(
                    text = "درباره من",
                    route = AppRoute.About,
                    currentRoute = currentRoute,
                    onNavigate = onNavigate,
                    onDismiss = {
                        menuExpanded = false
                    }
                )

                MobileNavigationItem(
                    text = "تماس با من",
                    route = AppRoute.Contact,
                    currentRoute = currentRoute,
                    onNavigate = onNavigate,
                    onDismiss = {
                        menuExpanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun MobileNavigationItem(
    text: String,
    route: AppRoute,
    currentRoute: AppRoute,
    onNavigate: (AppRoute) -> Unit,
    onDismiss: () -> Unit
) {
    TextButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            onNavigate(route)
            onDismiss()
        },
        colors = ButtonDefaults.textButtonColors(
            contentColor = if (currentRoute == route) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = if (currentRoute == route) {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            }
        )
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
            .padding(
                horizontal = AppDimensions.ContentPadding,
                vertical = AppDimensions.Space8
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        ThemeSelector(
            themeMode = themeMode,
            onThemeModeChange = onThemeModeChange
        )


        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            NavigationItem(
                text = "تماس با من",
                selected = currentRoute == AppRoute.Contact,
                onClick = { onNavigate(AppRoute.Contact) }
            )
            NavigationItem(
                text = "درباره من",
                selected = currentRoute == AppRoute.About,
                onClick = { onNavigate(AppRoute.About) }
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
                text = "خانه",
                selected = currentRoute == AppRoute.Home,
                onClick = { onNavigate(AppRoute.Home) }
            )

        }
        // سمت راست: نام
        AppLogo()
    }
}

@Composable
private fun MobileMenuButton(
    expanded: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (expanded) "✕" else "☰",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun NavigationItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    var isHovered by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.12f else 1f,
        animationSpec = tween(durationMillis = 180),
        label = "NavigationItemScale"
    )

    TextButton(
        onClick = onClick,
        modifier = Modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .onPointerEvent(PointerEventType.Enter) {
                isHovered = true
            }
            .onPointerEvent(PointerEventType.Exit) {
                isHovered = false
            },
        colors = ButtonDefaults.textButtonColors(
            contentColor = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        )
    ) {
        Text(
            text = text,
            fontWeight = if (selected) {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            }
        )
    }
}