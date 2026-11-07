package sadeqit.github.io.data.articles

import sadeqit.github.io.domain.model.ArticleBlock
import sadeqit.github.io.domain.model.ArticleContent
import sadeqit.github.io.domain.model.ArticleSection
import sadeqit.github.io.domain.model.CalloutType

internal val cleanArchitectureArticleContent = ArticleContent(
    intro = listOf(
        ArticleBlock.ParagraphBlock(
            text = "Clean Architecture یک الگوی معماری نرم‌افزار است که هدف آن جداسازی مسئولیت‌ها و مستقل نگه داشتن منطق اصلی برنامه از جزئیات پیاده‌سازی است."
        )
    ),
    sections = listOf(
        ArticleSection(
            id = "what-is-clean-architecture",
            title = "۱. Clean Architecture چیست؟",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "در این معماری، کدها به لایه‌های مشخص تقسیم می‌شوند تا منطق کسب‌وکار به فریم‌ورک‌ها، دیتابیس یا رابط کاربری وابسته نباشد."
                ),
                ArticleBlock.BulletListBlock(
                    items = listOf(
                        "جداسازی مسئولیت‌ها",
                        "کاهش وابستگی بین لایه‌ها",
                        "افزایش قابلیت تست",
                        "نگهداری و توسعه آسان‌تر"
                    )
                )
            )
        ),
        ArticleSection(
            id = "dependency-rule",
            title = "۲. قانون وابستگی",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "مهم‌ترین قانون Clean Architecture این است که وابستگی‌ها باید به سمت لایه‌های داخلی باشند. لایه‌های داخلی نباید جزئیات لایه‌های بیرونی را بشناسند."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "UserRepository.kt",
                    code = """
                        interface UserRepository {
                            suspend fun getUser(id: Int): User
                        }
                        
                        class GetUserUseCase(
                            private val repository: UserRepository
                        ) {
                            suspend operator fun invoke(
                                id: Int
                            ): User {
                                return repository.getUser(id)
                            }
                        }
                    """.trimIndent()
                )
            )
        ),
        ArticleSection(
            id = "architecture-benefits",
            title = "۳. مزایای استفاده",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "استفاده صحیح از این معماری می‌تواند تغییرات پروژه را آسان‌تر کند و امکان تست منطق اصلی را بدون اجرای تمام اجزای برنامه فراهم کند."
                ),
                ArticleBlock.CalloutBlock(
                    title = "نکته مهم",
                    text = "Clean Architecture به معنی ساختن تعداد زیادی لایه و کلاس نیست. معماری باید متناسب با نیاز واقعی پروژه باشد.",
                    type = CalloutType.TIP
                )
            )
        )
    ),
    conclusion = listOf(
        ArticleBlock.ParagraphBlock(
            text = "Clean Architecture با مشخص کردن مرز مسئولیت‌ها و کنترل جهت وابستگی‌ها، به ساخت نرم‌افزارهایی قابل نگهداری و توسعه کمک می‌کند."
        ),
        ArticleBlock.CalloutBlock(
            text = "هدف معماری خوب، مدیریت پیچیدگی است؛ نه افزایش تعداد کلاس‌ها و فایل‌ها.",
            type = CalloutType.SUCCESS
        )
    )
)
