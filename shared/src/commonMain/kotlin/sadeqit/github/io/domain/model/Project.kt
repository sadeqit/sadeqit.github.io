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
    val order: Int = 0
)