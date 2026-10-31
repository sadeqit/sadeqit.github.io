package sadeqit.github.io.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import sadeqit.github.io.domain.repository.ArticleRepository
import sadeqit.github.io.presentation.theme.AppDimensions

@Composable
fun ArticlesScreen() {
    val articleRepository = koinInject<ArticleRepository>()
    val articles = articleRepository.getArticles()

    Text(
        text = "Articles: ${articles.size}",
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimensions.ContentPadding)
    )
}