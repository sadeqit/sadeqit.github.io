package sadeqit.github.io.presentation.screens.articleScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import sadeqit.github.io.domain.model.Article
import sadeqit.github.io.domain.model.ArticleContent
import sadeqit.github.io.domain.repository.ArticleRepository
import sadeqit.github.io.presentation.components.article.ArticleContentRenderer
import sadeqit.github.io.presentation.theme.AppDimensions
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.article_clean_code
import sadeqit.shared.generated.resources.article_kotlin_multiplatform

@Composable
fun ArticleDetailsScreen(
    slug: String
) {
    val articleRepository = koinInject<ArticleRepository>()

    val article = remember(slug, articleRepository) {
        articleRepository.getArticles().firstOrNull { it.slug == slug }
    }

    var articleContent by remember(slug) {
        mutableStateOf<ArticleContent?>(null)
    }

    var isLoading by remember(slug) {
        mutableStateOf(true)
    }

    LaunchedEffect(slug, articleRepository) {
        isLoading = true
        articleContent = articleRepository.getArticleContent(slug)
        isLoading = false
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        when {
            article == null -> {
                Text(
                    text = "مقاله مورد نظر پیدا نشد.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            isLoading -> {
                Text(
                    text = "در حال بارگذاری مقاله...",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            articleContent == null -> {
                Text(
                    text = "محتوای این مقاله در دسترس نیست.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            else -> {
                ArticleHeader(article)

                ArticleContentRenderer(
                    blocks = articleContent!!.intro
                )

                articleContent!!.sections.forEach { section ->
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = section.title,
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        ArticleContentRenderer(
                            blocks = section.blocks
                        )
                    }
                }

                if (articleContent!!.conclusion.isNotEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "جمع‌بندی",
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        ArticleContentRenderer(
                            blocks = articleContent!!.conclusion
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ArticleHeader(
    article: Article
) {
    val coverPainter = when (article.cover) {
        "article_clean_code" ->
            painterResource(Res.drawable.article_clean_code)

        "article_kotlin_multiplatform" ->
            painterResource(Res.drawable.article_kotlin_multiplatform)

        else -> null
    }

    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth()
    ) {
        val isMobile = maxWidth <= 600.dp

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            if (isMobile) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    ArticleHeaderInfo(
                        article = article,
                        isMobile = true
                    )

                    coverPainter?.let {
                        ArticleCover(
                            painter = it,
                            title = article.title
                        )
                    }
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    horizontalArrangement = Arrangement.spacedBy(
                        AppDimensions.Space64
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .padding(24.dp)
                    ) {
                        ArticleHeaderInfo(
                            article = article,
                            isMobile = false
                        )
                    }

                    coverPainter?.let {
                        ArticleCover(
                            painter = it,
                            title = article.title,
                            modifier = Modifier.weight(0.9f)
                        )
                    }
                }
            }

            HorizontalDivider(
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }
    }
}

@Composable
private fun ArticleHeaderInfo(
    article: Article,
    isMobile: Boolean
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = if (isMobile) {
            Arrangement.spacedBy(24.dp)
        } else {
            Arrangement.SpaceBetween
        }
    ) {
        // عنوان
        Text(
            text = article.title,
            style = if (isMobile) {
                MaterialTheme.typography.headlineLarge
            } else {
                MaterialTheme.typography.displayLarge
            },
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )

        // توضیحات
        Text(
            text = article.excerpt,
            style = if (isMobile) {
                MaterialTheme.typography.bodyLarge
            } else {
                MaterialTheme.typography.titleLarge
            },
            color = MaterialTheme.colorScheme.onBackground
        )

        // اطلاعات مقاله
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // تاریخ و زمان مطالعه
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.date,
                    style = if (isMobile) {
                        MaterialTheme.typography.labelMedium
                    } else {
                        MaterialTheme.typography.bodyMedium
                    },
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(Modifier.width(150.dp))

                Text(
                    text = "${article.readTime} دقیقه مطالعه",
                    style = if (isMobile) {
                        MaterialTheme.typography.labelMedium
                    } else {
                        MaterialTheme.typography.bodyMedium
                    },
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            // تگ‌ها
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                article.tags.forEach { tag ->
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.10f)
                    ) {
                        Text(
                            text = tag,
                            modifier = Modifier.padding(
                                horizontal = if (isMobile) 12.dp else 14.dp,
                                vertical = if (isMobile) 7.dp else 9.dp
                            ),
                            style = if (isMobile) {
                                MaterialTheme.typography.labelMedium
                            } else {
                                MaterialTheme.typography.labelLarge
                            },
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ArticleCover(
    painter: Painter,
    title: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painter,
        contentDescription = title,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}
