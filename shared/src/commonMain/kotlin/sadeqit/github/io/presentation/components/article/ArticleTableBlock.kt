package sadeqit.github.io.presentation.components.article

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.ArticleBlock

@Composable
fun ArticleTableBlock(
    block: ArticleBlock.TableBlock,
    modifier: Modifier = Modifier
) {
    if (block.headers.isEmpty()) return

    val colorScheme = MaterialTheme.colorScheme

    Column(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .clip(RoundedCornerShape(10.dp))
            .border(
                1.dp,
                colorScheme.outlineVariant,
                RoundedCornerShape(10.dp)
            )
    ) {
        Row(
            modifier = Modifier.background(colorScheme.surfaceVariant)
        ) {
            block.headers.forEach { header ->
                Text(
                    text = header,
                    modifier = Modifier
                        .widthIn(min = 120.dp)
                        .padding(12.dp),
                    style = MaterialTheme.typography.titleSmall,
                    color = colorScheme.onSurface
                )
            }
        }

        block.rows.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorScheme.surface)
            ) {
                block.headers.indices.forEach { index ->
                    Text(
                        text = row.getOrNull(index).orEmpty(),
                        modifier = Modifier
                            .widthIn(min = 120.dp)
                            .padding(12.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorScheme.onBackground
                    )
                }
            }
        }
    }
}