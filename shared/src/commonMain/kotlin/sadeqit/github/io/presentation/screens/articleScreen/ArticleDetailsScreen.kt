package sadeqit.github.io.presentation.screens.articleScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import sadeqit.github.io.domain.model.Article
import sadeqit.github.io.domain.model.ArticleContent
import sadeqit.github.io.domain.repository.ArticleRepository
import sadeqit.github.io.presentation.components.article.ArticleContentRenderer
import sadeqit.github.io.presentation.components.articles.ArticleTableOfContents
import sadeqit.github.io.presentation.screens.home.HomeReveal
import sadeqit.shared.generated.resources.Res
import sadeqit.shared.generated.resources.article_clean_code
import sadeqit.shared.generated.resources.article_kotlin_multiplatform
import kotlin.math.roundToInt


@Composable
fun ArticleDetailsScreen(
    slug: String
) {
    val articleRepository = koinInject<ArticleRepository>()

    val article = remember(slug, articleRepository) {
        articleRepository.getArticles().firstOrNull {
            it.slug == slug
        }
    }

    var articleContent by remember(slug) {
        mutableStateOf<ArticleContent?>(null)
    }

    var isLoading by remember(slug) {
        mutableStateOf(true)
    }

    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current

    var viewportCoordinates by remember {
        mutableStateOf<LayoutCoordinates?>(null)
    }

    val sectionCoordinates = remember(articleContent) {
        mutableMapOf<String, LayoutCoordinates>()
    }

    LaunchedEffect(slug, articleRepository) {
        isLoading = true
        articleContent = articleRepository.getArticleContent(slug)
        isLoading = false
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .onGloballyPositioned {
                viewportCoordinates = it
            }
            .padding(horizontal = 24.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 960.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(32.dp)
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
                    val content = articleContent!!

                    ArticleHeader(article)

                    ArticleContentRenderer(
                        blocks = content.intro
                    )

                    ArticleTableOfContents(
                        sections = content.sections,
                        onSectionClick = { sectionId ->
                            scope.launch {
                                withFrameNanos { }

                                val section = sectionCoordinates[sectionId]
                                val viewport = viewportCoordinates

                                if (section != null && viewport != null) {
                                    val targetOffset = (
                                            section.positionInRoot().y -
                                                    viewport.positionInRoot().y -
                                                    with(density) { 16.dp.toPx() }
                                            ).roundToInt()
                                        .coerceIn(0, scrollState.maxValue)

                                    scrollState.animateScrollTo(targetOffset)
                                }
                            }
                        }
                    )

                    content.sections.forEach { section ->
                        HomeReveal {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onGloballyPositioned {
                                        sectionCoordinates[section.id] = it
                                    },
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                HorizontalDivider(
                                    color = MaterialTheme.colorScheme.outlineVariant,
                                    thickness = 2.dp
                                )

                                Spacer(Modifier.height(7.dp))

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
                    }

                    if (content.conclusion.isNotEmpty()) {
                        HomeReveal {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                HorizontalDivider(
                                    color = MaterialTheme.colorScheme.outlineVariant,
                                    thickness = 2.dp
                                )

                                Spacer(Modifier.height(7.dp))

                                Text(
                                    text = "جمع‌بندی",
                                    style = MaterialTheme.typography.headlineMedium,
                                    color = MaterialTheme.colorScheme.onBackground
                                )

                                ArticleContentRenderer(
                                    blocks = content.conclusion
                                )
                            }
                        }
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

    val isMobile = LocalWindowInfo.current.containerSize.width.let {
        it / LocalDensity.current.density <= 600
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(24.dp)
        ) {
            ArticleHeaderInfo(
                article = article,
                isMobile = isMobile
            )
        }

        coverPainter?.let {
            ArticleCover(
                painter = it,
                title = article.title
            )
        }
        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant,
            thickness = 2.dp
        )
    }
}


@Composable
private fun ArticleHeaderInfo(
    article: Article,
    isMobile: Boolean
) {
    val colorScheme = MaterialTheme.colorScheme

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // عنوان و توضیحات
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = article.title,
                style = if (isMobile) {
                    MaterialTheme.typography.headlineLarge
                } else {
                    MaterialTheme.typography.displaySmall
                },
                color = colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = article.excerpt,
                style = if (isMobile) {
                    MaterialTheme.typography.bodyLarge
                } else {
                    MaterialTheme.typography.titleLarge
                },
                color = colorScheme.onBackground
            )
        }

        HorizontalDivider(
            color = colorScheme.outlineVariant
        )

        // تاریخ و زمان مطالعه
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = article.date,
                style = MaterialTheme.typography.bodyMedium,
                color = colorScheme.onBackground
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = "${article.readTime} دقیقه مطالعه",
                style = MaterialTheme.typography.bodyMedium,
                color = colorScheme.onBackground
            )
        }

        HorizontalDivider(
            color = colorScheme.outlineVariant
        )

        // تگ‌ها
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            article.tags.forEach { tag ->
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = colorScheme.primary.copy(alpha = 0.10f)
                ) {
                    Text(
                        text = tag,
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 7.dp
                        ),
                        style = MaterialTheme.typography.labelMedium,
                        color = colorScheme.primary
                    )
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
