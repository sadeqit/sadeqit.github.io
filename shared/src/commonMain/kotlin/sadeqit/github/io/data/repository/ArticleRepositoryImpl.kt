package sadeqit.github.io.data.repository

import sadeqit.github.io.data.content.articleData
import sadeqit.github.io.data.articles.cleanArchitectureArticleContent
import sadeqit.github.io.data.articles.cleanCodeArticleContent
import sadeqit.github.io.data.articles.kotlinMultiplatformArticleContent
import sadeqit.github.io.domain.model.Article
import sadeqit.github.io.domain.model.ArticleContent
import sadeqit.github.io.domain.repository.ArticleRepository

class ArticleRepositoryImpl : ArticleRepository {

    // اضافه کردن مقاله جدید
    private val articleContents = mapOf(
        "clean-code" to cleanCodeArticleContent,
        "clean-architecture" to cleanArchitectureArticleContent,
        "kotlin-multiplatform-introduction" to kotlinMultiplatformArticleContent
    )

    override fun getArticles(): List<Article> = articleData

    override fun getFeaturedArticles(): List<Article> =
        articleData.filter { it.featured }

    override suspend fun getArticleContent(slug: String): ArticleContent? =
        articleContents[slug]
}
