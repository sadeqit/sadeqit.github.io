package sadeqit.github.io.di

import org.koin.dsl.module
import sadeqit.github.io.data.repository.ArticleRepositoryImpl
import sadeqit.github.io.data.repository.ProjectRepositoryImpl
import sadeqit.github.io.domain.repository.ArticleRepository
import sadeqit.github.io.domain.repository.ProjectRepository

val appModule = module {

    single<ProjectRepository> {
        ProjectRepositoryImpl()
    }

    single<ArticleRepository> {
        ArticleRepositoryImpl()
    }
}