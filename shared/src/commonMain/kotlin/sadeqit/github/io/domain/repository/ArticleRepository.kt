package sadeqit.github.io.domain.repository

import sadeqit.github.io.domain.model.Article
import sadeqit.github.io.domain.model.ArticleContent

interface ArticleRepository {

    fun getArticles(): List<Article>

    fun getFeaturedArticles(): List<Article>

    suspend fun getArticleContent(slug: String): ArticleContent?
}