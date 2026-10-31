package sadeqit.github.io.presentation.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.Article
import sadeqit.github.io.presentation.components.AnimatedOutlinedButton
import sadeqit.github.io.presentation.components.rememberHoverEffect
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeArticles(
    isMobile: Boolean,
    articles: List<Article>,
    onArticlesClick: () -> Unit,
) {
    HomeContainer(
        modifier = Modifier.padding(
            vertical = AppDimensions.Space48
        )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space40)
        ) {
            HomeReveal {
                SectionHeader(
                    eyebrow = "ARTICLES",
                    title = "آنچه یاد می‌ گیرم، می‌ نویسم",
                    description = "نوشته‌ هایی از تجربه‌ ها و آموخته‌ ها — درباره موضوعاتی که ارزش یادگیری و به اشتراک گذاشتن دارند."
                )
            }

            HorizontalCardRow {
                if (isMobile) {
                    articles.forEach { article ->
                        ArticleCard(
                            modifier = Modifier.width(280.dp),
                            article = article,
                            onClick = onArticlesClick
                        )
                    }
                } else {
                    articles.forEach { article ->
                        HomeReveal {
                            ArticleCard(
                                modifier = Modifier.width(280.dp),
                                article = article,
                                onClick = onArticlesClick
                            )
                        }
                    }
                }
            }

            HomeReveal {
                AnimatedOutlinedButton(
                    onClick = onArticlesClick,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("مشاهده همه مقالات")
                }
            }

        }
    }
}

@Composable
private fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit,
) {
    val hoverEffect = rememberHoverEffect(
        enableScale = true
    )

    Card(
        onClick = onClick,
        modifier = modifier.graphicsLayer {
            scaleX = hoverEffect.scale
            scaleY = hoverEffect.scale
        },
        border = BorderStroke(
            width = AppDimensions.BorderThin,
            brush = hoverEffect.borderBrush
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        interactionSource = hoverEffect.interactionSource,
    ) {
        Column(
            modifier = Modifier.padding(AppDimensions.Space20),
            verticalArrangement = Arrangement.spacedBy(AppDimensions.Space16)
        ) {
            Text(
                text = article.tags.firstOrNull()?.uppercase() ?: "ARTICLE",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = article.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "مطالعه مقاله →",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
