package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import sadeqit.github.io.domain.repository.ArticleRepository
import sadeqit.github.io.presentation.components.AppFooter
import sadeqit.github.io.presentation.components.ArticleCard
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun ArticlesScreen(
    onArticleClick: (String) -> Unit
) {
    val articleRepository = koinInject<ArticleRepository>()
    val articles = remember(articleRepository) {
        articleRepository.getArticles()
    }

    val spacing = AppDimensions.Space24

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val isMobile = maxWidth < 600.dp
        val columnCount = if (isMobile) 1 else 3

        val horizontalPadding = if (isMobile) 16.dp else 0.dp

        val contentModifier = Modifier
            .widthIn(max = 1250.dp)
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)

        val cardWidth = if (isMobile) 380.dp else 400.dp

        val articleRows = articles.chunked(columnCount)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                top = AppDimensions.Space32,
                bottom = 0.dp
            ),
            verticalArrangement = Arrangement.spacedBy(
                AppDimensions.Space8
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item(key = "articles-header") {
                HomeReveal {
                    Column(
                        modifier = contentModifier,
                        verticalArrangement = Arrangement.spacedBy(
                            AppDimensions.Space12
                        )
                    ) {
                        Text(
                            text = "مقالات",
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "نوشته‌هایی درباره تجربه‌ها، آموخته‌ها و موضوعات مرتبط با توسعه نرم‌افزار.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        Spacer(
                            modifier = Modifier.height(AppDimensions.Space8)
                        )

                        Text(
                            text = "همه مقالات",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold
                        )

                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                    }
                }
            }

            if (articles.isEmpty()) {
                item(key = "empty-articles") {
                    Box(
                        modifier = contentModifier
                    ) {
                        Text(
                            text = "هنوز مقاله‌ای منتشر نشده است.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            } else {
                itemsIndexed(
                    items = articleRows,
                    key = { _, row ->
                        row.joinToString("-") { it.id }
                    }
                ) { index, row ->
                    HomeReveal {
                        Column(
                            modifier = contentModifier,
                            verticalArrangement = Arrangement.spacedBy(
                                AppDimensions.Space16
                            )
                        ) {
                            Spacer(
                                modifier = Modifier.height(
                                    AppDimensions.Space16
                                )
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(
                                    spacing,
                                    Alignment.CenterHorizontally
                                )
                            ) {
                                row.forEach { article ->
                                    ArticleCard(
                                        modifier = Modifier.width(cardWidth),
                                        article = article,
                                        onClick = onArticleClick
                                    )
                                }
                            }

                            if (index < articleRows.lastIndex) {
                                Spacer(
                                    modifier = Modifier.height(
                                        AppDimensions.Space16
                                    )
                                )

                                HorizontalDivider(
                                    color = MaterialTheme.colorScheme.outlineVariant
                                )
                            }
                        }
                    }
                }
            }

            item {
                Spacer(
                    modifier = Modifier.height(AppDimensions.Space24)
                )
            }

            item(key = "app-footer") {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CompositionLocalProvider(
                        LocalLayoutDirection provides LayoutDirection.Ltr
                    ) {
                        AppFooter()
                    }
                }
            }
        }
    }
}
