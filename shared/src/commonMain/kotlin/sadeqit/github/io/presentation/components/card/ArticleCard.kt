package sadeqit.github.io.presentation.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import sadeqit.github.io.domain.model.Article
import sadeqit.github.io.presentation.theme.AppColors
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.article_clean_code
import sadeqit.shared.generated.resources.article_kotlin_multiplatform

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: (String) -> Unit,
) {

    val articleImage = when (article.cover) {
        "article_clean_code" ->
            painterResource(Res.drawable.article_clean_code)

        "article_kotlin_multiplatform" ->
            painterResource(Res.drawable.article_kotlin_multiplatform)

        else -> null
    }

    HoverCard(
        modifier = modifier.height(580.dp),
        shape = RoundedCornerShape(AppDimensions.Space16),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Article Image
            Box(
                modifier = Modifier
                    .weight(0.8f)
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = AppDimensions.Space16,
                            topEnd = AppDimensions.Space16
                        )
                    )
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                if (articleImage != null) {
                    Image(
                        painter = articleImage,
                        contentDescription = article.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // Article Content
            Column(
                modifier = Modifier
                    .weight(1.2f)
                    .fillMaxWidth()
                    .padding(AppDimensions.Space20)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        AppDimensions.Space12
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            AppDimensions.Space8
                        )
                    ) {
                        article.tags.take(2).forEachIndexed { index, tag ->
                            ArticleTagChip(
                                tag = tag,
                                index = index
                            )
                        }
                    }

                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant
                    )

                    Text(
                        text = article.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,

                        )

                    Text(
                        text = article.excerpt,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(
                    modifier = Modifier.weight(1f)
                )

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outlineVariant
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = AppDimensions.Space8),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = article.date,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "${article.readTime} دقیقه مطالعه",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = AppDimensions.Space4),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = { onClick(article.slug) }
                    ) {
                        Text("مشاهده مقاله")

                        Spacer(
                            modifier = Modifier.size(AppDimensions.Space8)
                        )

                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                            contentDescription = "مشاهده جزئیات مقاله"
                        )
                    }
                }

            }
        }
    }
}

@Composable
private fun ArticleTagChip(
    tag: String,
    index: Int
) {
    val isDark = MaterialTheme.colorScheme.background == AppColors.DarkBackground

    val (backgroundColor, textColor) = when (index) {
        0 -> (
                if (isDark) AppColors.ArticleTagPrimaryDarkBackground
                else AppColors.ArticleTagPrimaryBackground
                ) to (
                if (isDark) AppColors.ArticleTagPrimaryDark
                else AppColors.ArticleTagPrimary
                )

        else -> (
                if (isDark) AppColors.ArticleTagSecondaryDarkBackground
                else AppColors.ArticleTagSecondaryBackground
                ) to (
                if (isDark) AppColors.ArticleTagSecondaryDark
                else AppColors.ArticleTagSecondary
                )
    }

    ProjectInfoChip(
        label = tag,
        backgroundColor = backgroundColor,
        textColor = textColor
    )
}