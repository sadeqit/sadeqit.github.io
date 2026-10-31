package sadeqit.github.io.domain.model

data class Article(
    val id: String,
    val title: String,
    val excerpt: String,
    val cover: String? = null,
    val tags: List<String>,
    val date: String,
    val readTime: Int,
    val slug: String,
    val featured: Boolean = false,
    val content: String
)