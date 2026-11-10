package sadeqit.github.io.domain.model

/**
 * Represents a single content block inside an article section.
 */
sealed interface ArticleBlock {

    /**
     * A heading inside an article section.
     */
    data class HeadingBlock(
        val text: String,
        val level: Int = 3
    ) : ArticleBlock

    /**
     * A regular paragraph.
     */
    data class ParagraphBlock(
        val text: String
    ) : ArticleBlock

    /**
     * A code snippet displayed inside a code editor window.
     */
    data class CodeBlock(
        val code: String,
        val language: String,
        val fileName: String? = null,
        val title: String? = null,
        val showLineNumbers: Boolean = true
    ) : ArticleBlock

    /**
     * An image loaded from Compose Resources.
     *
     * resourceName is the drawable resource name,
     * without its file extension.
     */
    data class ImageBlock(
        val resourceName: String,
        val description: String,
        val caption: String? = null
    ) : ArticleBlock

    /**
     * A bulleted list.
     */
    data class BulletListBlock(
        val items: List<String>
    ) : ArticleBlock

    /**
     * A numbered list.
     */
    data class NumberedListBlock(
        val items: List<String>
    ) : ArticleBlock

    /**
     * A quotation.
     */
    data class QuoteBlock(
        val text: String,
        val attribution: String? = null
    ) : ArticleBlock

    /**
     * A table.
     */
    data class TableBlock(
        val headers: List<String>,
        val rows: List<List<String>>
    ) : ArticleBlock

    /**
     * A visual divider between content blocks.
     */
    data object DividerBlock : ArticleBlock

    /**
     * An informational, warning, or success callout.
     */
    data class CalloutBlock(
        val text: String,
        val type: CalloutType = CalloutType.INFO,
        val title: String? = null
    ) : ArticleBlock
}

/**
 * Visual type of callout block.
 */
enum class CalloutType {
    INFO,
    TIP,
    WARNING,
    SUCCESS
}
