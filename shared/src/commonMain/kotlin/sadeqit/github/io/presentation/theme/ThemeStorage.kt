package sadeqit.github.io.presentation.theme

internal expect object ThemeStorage {
    fun load(): AppThemeMode?
    fun save(themeMode: AppThemeMode)
}