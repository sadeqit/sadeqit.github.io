package sadeqit.github.io.data.articles

import sadeqit.github.io.domain.model.ArticleBlock
import sadeqit.github.io.domain.model.ArticleContent
import sadeqit.github.io.domain.model.ArticleSection
import sadeqit.github.io.domain.model.CalloutType

internal val kotlinMultiplatformArticleContent = ArticleContent(
    intro = listOf(
        ArticleBlock.ParagraphBlock(
            text = "Kotlin Multiplatform یا KMP فناوری‌ای از JetBrains است که به توسعه‌دهندگان اجازه می‌دهد منطق مشترک برنامه را بین پلتفرم‌های مختلف به اشتراک بگذارند؛ بدون اینکه مجبور باشند تمام کدهای برنامه را برای هر پلتفرم از ابتدا بنویسند."
        ),
        ArticleBlock.CalloutBlock(
            title = "ایده اصلی KMP",
            text = "یک بار منطق برنامه را بنویسید و تا جای ممکن در پلتفرم‌های مختلف از آن استفاده کنید.",
            type = CalloutType.INFO
        )
    ),
    sections = listOf(
        ArticleSection(
            id = "what-is-kmp",
            title = "۱. Kotlin Multiplatform چیست؟",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "Kotlin Multiplatform یک فناوری چندسکویی است که امکان اشتراک‌گذاری کد بین Android، iOS، Desktop، Web و سایر پلتفرم‌ها را فراهم می‌کند."
                ),
                ArticleBlock.ParagraphBlock(
                    text = "برخلاف برخی راهکارهای چندسکویی، KMP شما را مجبور نمی‌کند تمام رابط کاربری را با یک فناوری مشترک بسازید. می‌توانید منطق برنامه را مشترک نگه دارید و رابط کاربری بومی هر پلتفرم را حفظ کنید."
                )
            )
        ),
        ArticleSection(
            id = "how-it-works",
            title = "۲. KMP چگونه کار می‌کند؟",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "در پروژه‌های Kotlin Multiplatform، کدهای مشترک معمولاً در source set به نام commonMain قرار می‌گیرند. کدهای اختصاصی هر پلتفرم نیز در source set مربوط به همان پلتفرم نوشته می‌شوند."
                ),
                ArticleBlock.CodeBlock(
                    language = "text",
                    fileName = "Project Structure",
                    code = """
                        MyProject/
                        ├── shared/
                        │   └── src/
                        │       ├── commonMain/
                        │       ├── androidMain/
                        │       ├── iosMain/
                        │       ├── desktopMain/
                        │       └── wasmJsMain/
                        │
                        └── androidApp/
                    """.trimIndent()
                ),
                ArticleBlock.ParagraphBlock(
                    text = "برای مثال، مدل‌های داده، منطق کسب‌وکار و بخش زیادی از ارتباط با API می‌توانند در commonMain قرار بگیرند؛ درحالی‌که کدهای وابسته به سیستم‌عامل در source set اختصاصی خودشان پیاده‌سازی می‌شوند."
                )
            )
        ),
        ArticleSection(
            id = "shared-code-example",
            title = "۳. یک نمونه از کد مشترک",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "فرض کنید می‌خواهیم تابعی برای محاسبه قیمت نهایی محصول داشته باشیم. این منطق به سیستم‌عامل خاصی وابسته نیست و می‌توان آن را در commonMain نوشت."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "PriceCalculator.kt",
                    code = """
                        class PriceCalculator {

                            fun calculateTotal(
                                price: Double,
                                quantity: Int
                            ): Double {
                                return price * quantity
                            }
                        }
                    """.trimIndent()
                ),
                ArticleBlock.ParagraphBlock(
                    text = "اکنون همین کلاس می‌تواند از کد Android، iOS، Desktop یا سایر پلتفرم‌های هدف استفاده شود؛ بدون اینکه منطق محاسبه را دوباره پیاده‌سازی کنیم."
                )
            )
        ),
        ArticleSection(
            id = "expect-actual",
            title = "۴. استفاده از expect و actual",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "گاهی به قابلیتی نیاز داریم که پیاده‌سازی آن در هر پلتفرم متفاوت است. در چنین شرایطی می‌توان از مکانیزم expect و actual استفاده کرد."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "Platform.kt",
                    code = """
                        // commonMain
                        expect fun getPlatformName(): String
                    """.trimIndent()
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "Platform.android.kt",
                    code = """
                        // androidMain
                        actual fun getPlatformName(): String {
                            return "Android"
                        }
                    """.trimIndent()
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "Platform.ios.kt",
                    code = """
                        // iosMain
                        actual fun getPlatformName(): String {
                            return "iOS"
                        }
                    """.trimIndent()
                ),
                ArticleBlock.CalloutBlock(
                    text = "از expect و actual فقط زمانی استفاده کنید که واقعاً به پیاده‌سازی متفاوت در پلتفرم‌ها نیاز دارید.",
                    type = CalloutType.TIP
                )
            )
        ),
        ArticleSection(
            id = "supported-platforms",
            title = "۵. پلتفرم‌های قابل پشتیبانی",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "Kotlin Multiplatform امکان هدف‌گیری پلتفرم‌های مختلف را فراهم می‌کند. انتخاب پلتفرم‌ها به نیاز پروژه و کتابخانه‌های مورد استفاده بستگی دارد."
                ),
                ArticleBlock.BulletListBlock(
                    items = listOf(
                        "Android",
                        "iOS",
                        "Desktop با JVM",
                        "Web با Kotlin/JS",
                        "Web با Kotlin/Wasm",
                        "Server با Kotlin/JVM"
                    )
                ),
                ArticleBlock.ParagraphBlock(
                    text = "لازم نیست تمام این پلتفرم‌ها را در یک پروژه فعال کنید. فقط targetهایی را اضافه کنید که واقعاً به آن‌ها نیاز دارید."
                )
            )
        ),
        ArticleSection(
            id = "compose-multiplatform",
            title = "۶. ارتباط KMP با Compose Multiplatform",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "Compose Multiplatform یک فریم‌ورک رابط کاربری چندسکویی مبتنی بر Kotlin و Jetpack Compose است که می‌تواند در کنار Kotlin Multiplatform برای اشتراک‌گذاری UI نیز استفاده شود."
                ),
                ArticleBlock.ParagraphBlock(
                    text = "با استفاده از آن می‌توان بخش زیادی از رابط کاربری را بین Android، iOS، Desktop و Web به اشتراک گذاشت؛ البته میزان پشتیبانی و امکانات در هر پلتفرم متفاوت است."
                ),
                ArticleBlock.CalloutBlock(
                    title = "تفاوت مهم",
                    text = "Kotlin Multiplatform برای اشتراک‌گذاری کد است؛ Compose Multiplatform امکان اشتراک‌گذاری رابط کاربری را هم فراهم می‌کند.",
                    type = CalloutType.SUCCESS
                )
            )
        ),
        ArticleSection(
            id = "benefits-and-challenges",
            title = "۷. مزایا و چالش‌های KMP",
            blocks = listOf(
                ArticleBlock.HeadingBlock(
                    text = "مزایا",
                    level = 3
                ),
                ArticleBlock.BulletListBlock(
                    items = listOf(
                        "کاهش تکرار کد بین پلتفرم‌ها",
                        "استفاده مجدد از منطق کسب‌وکار",
                        "حفظ امکان توسعه بومی",
                        "استفاده از اکوسیستم Kotlin",
                        "تست و نگهداری آسان‌تر بخش‌های مشترک"
                    )
                ),
                ArticleBlock.HeadingBlock(
                    text = "چالش‌ها",
                    level = 3
                ),
                ArticleBlock.BulletListBlock(
                    items = listOf(
                        "تفاوت امکانات و محدودیت‌های پلتفرم‌ها",
                        "نیاز به شناخت Gradle و ساختار source setها",
                        "بررسی سازگاری کتابخانه‌ها با پلتفرم‌های هدف",
                        "پیچیدگی احتمالی در ارتباط با APIهای بومی"
                    )
                )
            )
        ),
        ArticleSection(
            id = "when-to-use-kmp",
            title = "۸. چه زمانی از KMP استفاده کنیم؟",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "KMP زمانی انتخاب مناسبی است که بخواهید منطق اصلی برنامه را بین چند پلتفرم به اشتراک بگذارید، اما همچنان آزادی استفاده از قابلیت‌ها و رابط کاربری بومی را داشته باشید."
                ),
                ArticleBlock.BulletListBlock(
                    items = listOf(
                        "وقتی چند نسخه از یک برنامه دارید.",
                        "وقتی منطق کسب‌وکار بین پلتفرم‌ها مشترک است.",
                        "وقتی می‌خواهید از Kotlin در چند پلتفرم استفاده کنید.",
                        "وقتی حفظ تجربه بومی هر پلتفرم اهمیت دارد."
                    )
                ),
                ArticleBlock.CalloutBlock(
                    title = "توصیه",
                    text = "پیش از انتخاب KMP، میزان کد قابل اشتراک‌گذاری و نیازهای اختصاصی هر پلتفرم را بررسی کنید.",
                    type = CalloutType.WARNING
                )
            )
        )
    ),
    conclusion = listOf(
        ArticleBlock.ParagraphBlock(
            text = "Kotlin Multiplatform راهکاری انعطاف‌پذیر برای توسعه نرم‌افزارهای چندسکویی است. این فناوری به شما اجازه می‌دهد منطق مشترک را یک بار پیاده‌سازی کنید و در عین حال، در صورت نیاز از امکانات بومی هر پلتفرم بهره ببرید."
        ),
        ArticleBlock.CalloutBlock(
            title = "جمع‌بندی",
            text = "KMP قرار نیست انتخاب‌های شما را محدود کند؛ هدف آن کاهش کدهای تکراری و ساده‌تر کردن توسعه چندسکویی است.",
            type = CalloutType.SUCCESS
        )
    )
)
