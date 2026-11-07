package sadeqit.github.io.presentation.components.article

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.DrawableResource
import sadeqit.github.io.domain.model.ArticleBlock
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.article_clean_code
import sadeqit.shared.generated.resources.article_kotlin_multiplatform

@Composable
fun ArticleImageBlock(
    block: ArticleBlock.ImageBlock,
    modifier: Modifier = Modifier
) {
    val imageResource: DrawableResource? = when (block.resourceName) {
        "article_clean_code" -> Res.drawable.article_clean_code
        "article_kotlin_multiplatform" -> Res.drawable.article_kotlin_multiplatform
        else -> null
    }

    if (imageResource != null) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = block.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            block.caption?.let { caption ->
                Text(
                    text = caption,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}