package sadeqit.github.io.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = AppColors.LightPrimary,
    onPrimary = AppColors.LightSurfaceElevated,
    primaryContainer = AppColors.LightPrimarySoft,
    onPrimaryContainer = AppColors.LightTextPrimary,
    secondary = AppColors.LightAccent,
    onSecondary = AppColors.LightSurfaceElevated,
    background = AppColors.LightBackground,
    onBackground = AppColors.LightTextPrimary,
    surface = AppColors.LightSurface,
    onSurface = AppColors.LightTextPrimary,
    surfaceVariant = AppColors.LightSurfaceElevated,
    onSurfaceVariant = AppColors.LightTextSecondary,
    outline = AppColors.LightBorder,
    outlineVariant = AppColors.LightBorderStrong
)

private val DarkColorScheme = darkColorScheme(
    primary = AppColors.DarkPrimary,
    onPrimary = AppColors.DarkBackground,
    primaryContainer = AppColors.DarkPrimarySoft,
    onPrimaryContainer = AppColors.DarkTextPrimary,
    secondary = AppColors.DarkAccent,
    onSecondary = AppColors.DarkBackground,
    background = AppColors.DarkBackground,
    onBackground = AppColors.DarkTextPrimary,
    surface = AppColors.DarkSurface,
    onSurface = AppColors.DarkTextPrimary,
    surfaceVariant = AppColors.DarkSurfaceElevated,
    onSurfaceVariant = AppColors.DarkTextSecondary,
    outline = AppColors.DarkBorder,
    outlineVariant = AppColors.DarkBorderStrong
)

enum class AppThemeMode {
    Light,
    Dark
}

@Composable
fun AppTheme(
    themeMode: AppThemeMode,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = when (themeMode) {
            AppThemeMode.Light -> LightColorScheme
            AppThemeMode.Dark -> DarkColorScheme
        },
        typography = AppTypography.typography(),
        shapes = AppShapes.shapes,
        content = content
    )
}