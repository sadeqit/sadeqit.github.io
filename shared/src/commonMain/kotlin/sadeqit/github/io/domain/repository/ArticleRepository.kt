package sadeqit.github.io.domain.repository

import sadeqit.github.io.domain.model.Article

interface ArticleRepository {

    fun getArticles(): List<Article>

    fun getFeaturedArticles(): List<Article>
}