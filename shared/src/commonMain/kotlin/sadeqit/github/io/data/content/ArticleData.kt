package sadeqit.github.io.data.content

import sadeqit.github.io.domain.model.Article

internal val articleData = listOf(
    Article(
        id = "kotlin-multiplatform-introduction",
        title = "آشنایی با Kotlin Multiplatform",
        excerpt = "نگاهی به Kotlin Multiplatform و اینکه چگونه می‌توان با یک کدبیس، منطق مشترک را بین پلتفرم‌های مختلف به اشتراک گذاشت.",
        cover = null,
        tags = listOf(
            "Kotlin",
            "KMP",
            "Compose Multiplatform"
        ),
        date = "2026-10-31",
        readTime = 5,
        slug = "kotlin-multiplatform-introduction",
        featured = true,
        content = """
# آشنایی با Kotlin Multiplatform

Kotlin Multiplatform یکی از فناوری‌های جذاب اکوسیستم Kotlin است که امکان اشتراک‌گذاری بخش‌هایی از کد را بین پلتفرم‌های مختلف فراهم می‌کند.

## Kotlin Multiplatform چیست؟

با استفاده از Kotlin Multiplatform می‌توان منطق مشترک برنامه را یک بار پیاده‌سازی کرد و در پلتفرم‌هایی مانند Android، iOS، Desktop و Web از آن استفاده کرد.

این موضوع باعث می‌شود توسعه و نگهداری پروژه‌های چندسکویی ساده‌تر شود.

## Compose Multiplatform

در کنار Kotlin Multiplatform، Compose Multiplatform امکان ساخت رابط کاربری مشترک را نیز فراهم می‌کند.

در نتیجه می‌توان بخش قابل توجهی از یک برنامه را با Kotlin و Compose پیاده‌سازی کرد.

## مزایا

- اشتراک‌گذاری کد بین پلتفرم‌ها
- کاهش کد تکراری
- استفاده از Kotlin در بخش‌های مختلف پروژه
- امکان ساخت UI مشترک با Compose Multiplatform
- نگهداری ساده‌تر پروژه

## جمع‌بندی

Kotlin Multiplatform انتخاب مناسبی برای پروژه‌هایی است که نیاز دارند منطق و حتی رابط کاربری خود را بین چند پلتفرم به اشتراک بگذارند.

در پروژه‌های شخصی و حرفه‌ای، استفاده درست از KMP می‌تواند ساختار پروژه را ساده‌تر و توسعه آن را سریع‌تر کند.
        """.trimIndent()
    )
)