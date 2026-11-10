package sadeqit.github.io.domain.model

/**
 * Represents the complete content of an article.
 */
data class ArticleContent(
    val intro: List<ArticleBlock> = emptyList(),
    val sections: List<ArticleSection>,
    val conclusion: List<ArticleBlock> = emptyList()
)

/**
 * Represents a section of an article.
 *
 * Each section has a title and an ordered list of content blocks.
 */
data class ArticleSection(
    val id: String,
    val title: String,
    val blocks: List<ArticleBlock>
)
