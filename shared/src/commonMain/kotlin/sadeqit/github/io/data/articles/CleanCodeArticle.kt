package sadeqit.github.io.data.articles

import sadeqit.github.io.domain.model.ArticleBlock
import sadeqit.github.io.domain.model.ArticleContent
import sadeqit.github.io.domain.model.ArticleSection
import sadeqit.github.io.domain.model.CalloutType

internal val cleanCodeArticleContent = ArticleContent(
    intro = listOf(
        ArticleBlock.ParagraphBlock(
            text = """
                کد تمیز فقط کدی نیست که اجرا می‌شود؛ کدی است که خواندن، درک کردن،
                تغییر دادن و نگهداری آن ساده باشد.
                در پروژه‌های نرم‌افزاری، بخش زیادی از زمان توسعه صرف خواندن و
                درک کدهای موجود می‌شود. بنابراین نوشتن کدی خوانا و قابل نگهداری
                به اندازه پیاده‌سازی صحیح قابلیت‌ها اهمیت دارد.
            """.trimIndent()
        ),
        ArticleBlock.CalloutBlock(
            title = "یک اصل مهم",
            text = "کد را طوری بنویسید که توسعه‌دهنده بعدی بتواند آن را به‌راحتی درک کند؛ حتی اگر آن توسعه‌دهنده خودتان باشید.",
            type = CalloutType.TIP
        )
    ),
    sections = listOf(
        ArticleSection(
            id = "meaningful-names",
            title = "۱. از نام‌های معنادار استفاده کنید",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "نام متغیرها، توابع و کلاس‌ها باید هدف و مسئولیت آن‌ها را مشخص کند. نام‌های مبهم باعث می‌شوند خواننده برای فهمیدن کد مجبور به بررسی جزئیات پیاده‌سازی شود."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "BadNaming.kt",
                    code = """
                        val d = 10
                        val x = getData()
                        
                        fun calc(a: Int, b: Int): Int {
                            return a * b
                        }
                    """.trimIndent()
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "MeaningfulNames.kt",
                    code = """
                        val retryCount = 10
                        val weatherData = getWeatherData()
                        
                        fun calculateTotalPrice(
                            price: Int,
                            quantity: Int
                        ): Int {
                            return price * quantity
                        }
                    """.trimIndent()
                ),
                ArticleBlock.CalloutBlock(
                    text = "نام خوب نیاز به توضیح اضافی را کاهش می‌دهد.",
                    type = CalloutType.SUCCESS
                )
            )
        ),
        ArticleSection(
            id = "small-functions",
            title = "۲. توابع کوچک و متمرکز بنویسید",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "هر تابع بهتر است یک وظیفه مشخص داشته باشد. توابع طولانی معمولاً چند مسئولیت مختلف را با هم ترکیب می‌کنند و درک، تست و نگهداری آن‌ها دشوارتر است."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "UserRegistration.kt",
                    code = """
                        fun registerUser(user: User) {
                            validateUser(user)
                            saveUser(user)
                            sendWelcomeEmail(user)
                        }
                    """.trimIndent()
                ),
                ArticleBlock.ParagraphBlock(
                    text = "در این مثال، تابع اصلی مراحل ثبت‌نام را مشخص می‌کند و جزئیات هر مرحله به تابع جداگانه‌ای سپرده شده است."
                ),
                ArticleBlock.BulletListBlock(
                    items = listOf(
                        "هر تابع یک هدف مشخص داشته باشد.",
                        "نام تابع بیانگر کاری باشد که انجام می‌دهد.",
                        "از ترکیب چند مسئولیت نامرتبط در یک تابع خودداری کنید."
                    )
                )
            )
        ),
        ArticleSection(
            id = "single-responsibility",
            title = "۳. اصل مسئولیت واحد را رعایت کنید",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "یک کلاس یا ماژول باید مسئولیت مشخصی داشته باشد. وقتی یک کلاس چند دلیل مستقل برای تغییر دارد، توسعه و نگهداری آن دشوار می‌شود."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "UserRepository.kt",
                    code = """
                        class UserRepository(
                            private val database: UserDatabase,
                            private val api: UserApi
                        ) {
                            suspend fun getUser(id: Int): User {
                                return database.getUser(id)
                                    ?: api.getUser(id)
                            }
                        }
                    """.trimIndent()
                ),
                ArticleBlock.ParagraphBlock(
                    text = "در این ساختار، Repository مسئول مدیریت دسترسی به داده‌ها است. منطق نمایش رابط کاربری یا اعتبارسنجی ورودی‌ها نباید بدون دلیل به آن منتقل شود."
                ),
                ArticleBlock.CalloutBlock(
                    title = "نکته معماری",
                    text = "اصل مسئولیت واحد به معنی کوچک کردن اجباری تمام کلاس‌ها نیست؛ هدف، مشخص بودن مرز مسئولیت‌ها است.",
                    type = CalloutType.INFO
                )
            )
        ),
        ArticleSection(
            id = "avoid-duplication",
            title = "۴. از تکرار کد جلوگیری کنید",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "وقتی یک منطق در چند قسمت برنامه تکرار می‌شود، اصلاح آن باید در تمام نقاط انجام شود. این موضوع احتمال خطا و ناسازگاری را افزایش می‌دهد."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "DuplicatedCode.kt",
                    code = """
                        fun calculateFirstPrice(price: Int): Int {
                            return price + (price * 9 / 100)
                        }
                        
                        fun calculateSecondPrice(price: Int): Int {
                            return price + (price * 9 / 100)
                        }
                    """.trimIndent()
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "ReusableCode.kt",
                    code = """
                        fun calculatePriceWithTax(
                            price: Int
                        ): Int {
                            val tax = price * 9 / 100
                            return price + tax
                        }
                    """.trimIndent()
                ),
                ArticleBlock.ParagraphBlock(
                    text = "با استخراج منطق مشترک، تغییرات فقط در یک نقطه انجام می‌شوند. البته هر شباهت ظاهری الزاماً به معنی نیاز به یک تابع مشترک نیست."
                )
            )
        ),
        ArticleSection(
            id = "useful-comments",
            title = "۵. کامنت‌های مفید بنویسید",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "کامنت باید دلیل یا نکته‌ای را توضیح دهد که از خود کد به‌سادگی قابل فهم نیست. اگر کد به کامنت زیادی برای توضیح کارکرد خود نیاز دارد، بهتر است ابتدا خوانایی آن را بررسی کنید."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "Comments.kt",
                    code = """
                        // Bad: توضیح همان چیزی که کد نشان می‌دهد
                        // افزایش تعداد تلاش‌ها
                        retryCount++
                        
                        // Good: توضیح دلیل تصمیم
                        // سرویس مقصد پس از چند درخواست متوالی
                        // محدودیت موقت اعمال می‌کند.
                        delay(RATE_LIMIT_DELAY)
                    """.trimIndent()
                ),
                ArticleBlock.BulletListBlock(
                    items = listOf(
                        "دلیل تصمیم‌های غیرمعمول را توضیح دهید.",
                        "محدودیت‌ها و شرایط خاص را مستند کنید.",
                        "کامنت‌های قدیمی و نادرست را حذف یا اصلاح کنید.",
                        "از کامنت برای پنهان کردن کد پیچیده استفاده نکنید."
                    )
                )
            )
        ),
        ArticleSection(
            id = "consistent-formatting",
            title = "۶. قالب‌بندی یکپارچه داشته باشید",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "قالب‌بندی منظم باعث می‌شود ساختار کد سریع‌تر دیده شود. فاصله‌گذاری، شکست خطوط و ترتیب اعضای کلاس باید در سراسر پروژه تا حد امکان یکپارچه باشد."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "Formatting.kt",
                    code = """
                        class WeatherRepository(
                            private val api: WeatherApi,
                            private val cache: WeatherCache
                        ) {
                            suspend fun getWeather(
                                cityId: Int
                            ): Weather {
                                return cache.get(cityId)
                                    ?: api.getWeather(cityId)
                            }
                        }
                    """.trimIndent()
                ),
                ArticleBlock.CalloutBlock(
                    text = "در پروژه‌های Kotlin از Kotlin Coding Conventions و ابزارهایی مانند ktlint برای حفظ یکپارچگی قالب‌بندی استفاده کنید.",
                    type = CalloutType.TIP
                )
            )
        ),
        ArticleSection(
            id = "error-handling",
            title = "۷. خطاها را اصولی مدیریت کنید",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "خطاها بخشی طبیعی از اجرای برنامه هستند. به جای نادیده گرفتن آن‌ها، باید شرایط خطا را مشخص و متناسب با آن واکنش نشان داد."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "ErrorHandling.kt",
                    code = """
                        suspend fun loadUser(id: Int): User {
                            return try {
                                api.getUser(id)
                            } catch (exception: Exception) {
                                throw UserLoadException(
                                    "Unable to load user",
                                    exception
                                )
                            }
                        }
                    """.trimIndent()
                ),
                ArticleBlock.BulletListBlock(
                    items = listOf(
                        "خطاها را بی‌دلیل نادیده نگیرید.",
                        "از Exception عمومی فقط در صورت نیاز استفاده کنید.",
                        "اطلاعات کافی برای تشخیص مشکل فراهم کنید.",
                        "خطا را در لایه مناسب مدیریت کنید."
                    )
                )
            )
        ),
        ArticleSection(
            id = "immutability",
            title = "۸. تا حد امکان از تغییرپذیری پرهیز کنید",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "داده‌های تغییرپذیر می‌توانند باعث تغییرات ناخواسته و خطاهای دشوار برای ردیابی شوند. استفاده از val و ساختارهای داده غیرقابل‌تغییر، رفتار برنامه را قابل پیش‌بینی‌تر می‌کند."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "Immutability.kt",
                    code = """
                        // Mutable
                        var selectedCity = "Tehran"
                        
                        // Immutable
                        val selectedCityName = "Tehran"
                        
                        val cities = listOf(
                            "Tehran",
                            "Qom",
                            "Isfahan"
                        )
                    """.trimIndent()
                ),
                ArticleBlock.CalloutBlock(
                    text = "از val به عنوان انتخاب پیش‌فرض استفاده کنید و فقط زمانی سراغ var بروید که تغییر مقدار واقعاً ضروری باشد.",
                    type = CalloutType.SUCCESS
                )
            )
        ),
        ArticleSection(
            id = "write-tests",
            title = "۹. کد خود را تست کنید",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "تست‌ها کمک می‌کنند رفتار مورد انتظار برنامه مشخص شود و تغییرات جدید باعث خراب شدن قابلیت‌های قبلی نشوند. کدی که به‌راحتی تست می‌شود معمولاً ساختار و وابستگی‌های مشخص‌تری دارد."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "PriceCalculatorTest.kt",
                    code = """
                        class PriceCalculatorTest {
                            @Test
                            fun calculateTotalPrice() {
                                val result =
                                    calculateTotalPrice(
                                        price = 100,
                                        quantity = 3
                                    )
                        
                                assertEquals(300, result)
                            }
                        }
                    """.trimIndent()
                ),
                ArticleBlock.BulletListBlock(
                    items = listOf(
                        "رفتارهای اصلی را تست کنید.",
                        "شرایط مرزی را فراموش نکنید.",
                        "برای خطاهای احتمالی تست بنویسید.",
                        "تست‌ها باید مستقل و قابل تکرار باشند."
                    )
                )
            )
        ),
        ArticleSection(
            id = "keep-it-simple",
            title = "۱۰. سادگی را در اولویت قرار دهید",
            blocks = listOf(
                ArticleBlock.ParagraphBlock(
                    text = "راهکار ساده‌ای که نیاز فعلی را به‌درستی برطرف می‌کند، معمولاً انتخاب بهتری از معماری پیچیده و غیرضروری است. پیچیدگی اضافه، هزینه توسعه و نگهداری را افزایش می‌دهد."
                ),
                ArticleBlock.CodeBlock(
                    language = "kotlin",
                    fileName = "SimpleCode.kt",
                    code = """
                        fun isAdult(age: Int): Boolean {
                            return age >= 18
                        }
                    """.trimIndent()
                ),
                ArticleBlock.ParagraphBlock(
                    text = "از افزودن لایه‌ها، کلاس‌ها و abstractionهایی که کاربرد مشخصی ندارند خودداری کنید. کد باید به اندازه نیاز پروژه طراحی شود و در صورت تغییر نیازها، امکان توسعه داشته باشد."
                ),
                ArticleBlock.CalloutBlock(
                    title = "اصل طلایی",
                    text = "سادگی به معنی حذف اصول معماری نیست؛ یعنی برای حل هر مسئله، به اندازه نیاز آن پیچیدگی ایجاد کنیم.",
                    type = CalloutType.TIP
                )
            )
        )
    ),
    conclusion = listOf(
        ArticleBlock.ParagraphBlock(
            text = """
                Clean Code یک تکنیک یا قانون واحد نیست؛ مجموعه‌ای از عادت‌ها و
                اصولی است که کیفیت کد را در طول زمان حفظ می‌کنند.

                با رعایت نام‌گذاری مناسب، توابع متمرکز، مسئولیت‌های مشخص،
                تست‌نویسی و پرهیز از پیچیدگی غیرضروری می‌توان نرم‌افزاری
                ساخت که توسعه و نگهداری آن ساده‌تر باشد.
            """.trimIndent()
        ),
        ArticleBlock.CalloutBlock(
            title = "جمع‌بندی",
            text = "هدف نهایی، نوشتن کدی نیست که فقط امروز کار کند؛ هدف نوشتن کدی است که فردا هم بتوان آن را با اطمینان توسعه داد.",
            type = CalloutType.SUCCESS
        )
    )
)
