package sadeqit.github.io.data.repository

import sadeqit.github.io.data.content.articleData
import sadeqit.github.io.domain.model.Article
import sadeqit.github.io.domain.repository.ArticleRepository

class ArticleRepositoryImpl : ArticleRepository {

    override fun getArticles(): List<Article> {
        return articleData
    }

    override fun getFeaturedArticles(): List<Article> {
        return articleData.filter { it.featured }
    }
}