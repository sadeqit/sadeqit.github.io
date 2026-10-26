package sadeqit.github.io.presentation.theme

import kotlin.js.ExperimentalJsExport
import kotlin.js.js

private const val ThemeStorageKey = "sadeqit-theme"

@OptIn(ExperimentalJsExport::class)
private fun loadThemeValue(): String? =
    js("localStorage.getItem('$ThemeStorageKey')")

@OptIn(ExperimentalJsExport::class)
private fun saveThemeValue(value: String) {
    js("localStorage.setItem('$ThemeStorageKey', value)")
}

internal actual object ThemeStorage {

    actual fun load(): AppThemeMode? {
        return when (loadThemeValue()) {
            "light" -> AppThemeMode.Light
            "dark" -> AppThemeMode.Dark
            else -> null
        }
    }

    actual fun save(themeMode: AppThemeMode) {
        val value = when (themeMode) {
            AppThemeMode.Light -> "light"
            AppThemeMode.Dark -> "dark"
        }

        saveThemeValue(value)
    }
}