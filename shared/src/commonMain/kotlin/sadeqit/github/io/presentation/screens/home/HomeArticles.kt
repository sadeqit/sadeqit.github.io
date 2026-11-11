package sadeqit.github.io.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sadeqit.github.io.domain.model.Article
import sadeqit.github.io.presentation.components.AnimatedOutlinedButton
import sadeqit.github.io.presentation.components.card.ArticleCard
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun HomeArticles(
    isMobile: Boolean,
    articles: List<Article>,
    onArticlesClick: () -> Unit,
    onArticleClick: (String) -> Unit,
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
                            modifier = Modifier.width(380.dp),
                            article = article,
                            onClick = onArticleClick
                        )
                    }
                } else {
                    articles.forEach { article ->
                        HomeReveal {
                            ArticleCard(
                                modifier = Modifier.width(400.dp),
                                article = article,
                                onClick = onArticleClick
                            )
                        }
                    }
                }
            }

            HomeRevealItem(
                index = 1,
                isMobile = isMobile
            ) {
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