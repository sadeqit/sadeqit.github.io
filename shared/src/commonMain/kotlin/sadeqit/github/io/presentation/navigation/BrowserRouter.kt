package sadeqit.github.io.presentation.navigation

interface BrowserRouter {
    fun currentPath(): String

    fun navigate(path: String)

    fun back(fallbackPath: String)

    fun listen(onPathChanged: (String) -> Unit)

    fun clearListener()
}