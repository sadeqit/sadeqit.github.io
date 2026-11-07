package sadeqit.github.io.presentation.navigation

sealed interface AppRoute {
    data object Home : AppRoute
    data object Projects : AppRoute
    data class ProjectDetails(val projectId: String) : AppRoute

    data class ArticleDetails(val slug: String) : AppRoute
    data object Articles : AppRoute
    data object Resume : AppRoute
    data object About : AppRoute
    data object Contact : AppRoute
    data object NotFound : AppRoute

}

fun AppRoute.toPath(): String = when (this) {
    AppRoute.Home -> "/"
    AppRoute.Projects -> "/projects"
    is AppRoute.ProjectDetails -> "/projects/${this.projectId}"
    is AppRoute.ArticleDetails -> "/articles/${this.slug}"
    AppRoute.Articles -> "/articles"
    AppRoute.Resume -> "/resume"
    AppRoute.About -> "/about"
    AppRoute.Contact -> "/contact"
    AppRoute.NotFound -> "/404"
}

fun String.toAppRoute(): AppRoute {
    val path = substringBefore("?")
        .substringBefore("#")
        .trimEnd('/')
        .ifEmpty { "/" }

    return when {
        path == "/" -> AppRoute.Home
        path == "/projects" -> AppRoute.Projects

        path.startsWith("/projects/") -> {
            val projectId = path.removePrefix("/projects/")

            if (projectId.isNotBlank() && '/' !in projectId) {
                AppRoute.ProjectDetails(projectId)
            } else {
                AppRoute.NotFound
            }
        }

        path == "/articles" -> AppRoute.Articles

        path.startsWith("/articles/") -> {
            val slug = path.removePrefix("/articles/")

            if (slug.isNotBlank() && '/' !in slug) {
                AppRoute.ArticleDetails(slug)
            } else {
                AppRoute.NotFound
            }
        }

        path == "/resume" -> AppRoute.Resume
        path == "/about" -> AppRoute.About
        path == "/contact" -> AppRoute.Contact
        path == "/404" -> AppRoute.NotFound

        else -> AppRoute.NotFound
    }
}