package sadeqit.github.io.domain.model

data class Project(
    val id: String,
    val title: String,
    val description: String,
    val thumbnail: String? = null,
    val technologies: List<String>,
    val status: String,
    val githubUrl: String? = null,
    val appUrl: String? = null,
    val featured: Boolean = false,
    val order: Int = 0,
    val projectType: ProjectType,
    val releaseType: ProjectReleaseType,

    // Project Details
    val fullDescription: String = "",
    val goals: List<String> = emptyList(),
    val features: List<String> = emptyList(),
    val platforms: List<String> = emptyList(),
    val architecture: String = "",
    val challenges: List<ProjectChallenge> = emptyList(),
    val contributions: List<String> = emptyList(),
    val screenshots: List<String> = emptyList(),
    val achievements: List<String> = emptyList()
)

enum class ProjectType {
    Android,
    KMP
}

enum class ProjectReleaseType {
    Released,
    SourceCode
}

data class ProjectChallenge(
    val title: String,
    val problem: String,
    val solution: String
)