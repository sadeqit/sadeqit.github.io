package sadeqit.github.io.presentation.components.article

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import sadeqit.github.io.domain.model.ArticleBlock

@Composable
fun ArticleContentRenderer(
    blocks: List<ArticleBlock>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        blocks.forEach { block ->
            when (block) {
                is ArticleBlock.HeadingBlock -> {
                    Text(
                        text = block.text,
                        style = when (block.level) {
                            1 -> MaterialTheme.typography.headlineLarge
                            2 -> MaterialTheme.typography.headlineMedium
                            else -> MaterialTheme.typography.headlineSmall
                        },
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                is ArticleBlock.ParagraphBlock -> {
                    ArticleParagraph(text = block.text)
                }
                is ArticleBlock.CodeBlock -> {
                    ArticleCodeBlock(block = block)
                }

                is ArticleBlock.ImageBlock -> {
                    ArticleImageBlock(block = block)
                }

                is ArticleBlock.BulletListBlock -> {
                    ArticleListBlock(items = block.items)
                }

                is ArticleBlock.NumberedListBlock -> {
                    ArticleListBlock(
                        items = block.items,
                        numbered = true
                    )
                }

                is ArticleBlock.QuoteBlock -> {
                    ArticleQuoteBlock(block = block)
                }

                is ArticleBlock.TableBlock -> {
                    ArticleTableBlock(block = block)
                }

                ArticleBlock.DividerBlock -> {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant
                    )
                }

                is ArticleBlock.CalloutBlock -> {
                    ArticleCalloutBlock(block = block)
                }
            }
        }
    }
}
