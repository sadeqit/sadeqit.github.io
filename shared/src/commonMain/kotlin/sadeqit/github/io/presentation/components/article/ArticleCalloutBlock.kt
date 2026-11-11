package sadeqit.github.io.presentation.components.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sadeqit.github.io.domain.model.ArticleBlock
import sadeqit.github.io.domain.model.CalloutType

@Composable
fun ArticleCalloutBlock(
    block: ArticleBlock.CalloutBlock,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme

    val accentColor = when (block.type) {
        CalloutType.INFO -> colorScheme.primary
        CalloutType.TIP -> colorScheme.tertiary
        CalloutType.WARNING -> colorScheme.error
        CalloutType.SUCCESS -> colorScheme.secondary
    }

    val defaultTitle = when (block.type) {
        CalloutType.INFO -> "اطلاعات"
        CalloutType.TIP -> "نکته"
        CalloutType.WARNING -> "هشدار"
        CalloutType.SUCCESS -> "موفق"
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(accentColor.copy(alpha = 0.09f))
    ) {
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .background(accentColor)
                .padding(horizontal = 3.dp)
        )

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = block.title ?: defaultTitle,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                color = accentColor
            )

            Text(
                text = block.text,
                style = MaterialTheme.typography.bodyLarge.copy(
                    lineHeight = MaterialTheme.typography.bodyMedium.lineHeight * 1.5f
                ),
                color = colorScheme.onBackground,
                textAlign = TextAlign.Justify
            )
        }
    }
}