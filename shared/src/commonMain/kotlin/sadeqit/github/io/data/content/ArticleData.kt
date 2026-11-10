package sadeqit.github.io.data.content

import sadeqit.github.io.domain.model.Article

internal val articleData = listOf(
    Article(
        id = "kotlin-multiplatform-introduction",
        title = "آشنایی با Kotlin Multiplatform",
        excerpt = "نگاهی به Kotlin Multiplatform و اینکه چگونه می‌توان با یک کدبیس، منطق مشترک را بین پلتفرم‌های مختلف به اشتراک گذاشت.",
        cover = "article_kotlin_multiplatform",
        tags = listOf(
            "Kotlin",
            "KMP",
            "Compose Multiplatform"
        ),
        date = "2026-10-31",
        readTime = 5,
        slug = "kotlin-multiplatform-introduction",
        featured = true

    ),
    Article(
        id = "clean-code",
        title = "Clean Code",
        excerpt = "اصول نوشتن کدی خوانا، قابل نگهداری و توسعه‌پذیر در پروژه‌های نرم‌افزاری.",
        cover = "article_clean_code",
        tags = listOf(
            "Clean Code",
            "Programming",
            "Software Architecture"
        ),
        date = "2026-11-06",
        readTime = 5,
        slug = "clean-code",
        featured = true

    ),
    Article(
        id = "clean-architecture",
        title = "آشنایی با Clean Architecture",
        excerpt = "بررسی اصول معماری Clean Architecture و جداسازی مسئولیت‌ها در پروژه‌های نرم‌افزاری.",
        cover = "article_clean_code",
        tags = listOf(
            "Kotlin",
            "Clean Architecture",
            "Software Architecture"
        ),
        date = "2026-11-07",
        readTime = 4,
        slug = "clean-architecture",
        featured = true
    ),

)