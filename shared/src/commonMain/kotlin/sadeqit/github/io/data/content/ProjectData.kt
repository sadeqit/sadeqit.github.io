package sadeqit.github.io.data.content

import sadeqit.github.io.domain.model.Project
import sadeqit.github.io.domain.model.ProjectChallenge
import sadeqit.github.io.domain.model.ProjectReleaseType
import sadeqit.github.io.domain.model.ProjectType

internal val projectData = listOf(

    Project(
        id = "sadegh-dream",
        title = "تعبیر خواب صادق",
        description = "مرجعی فارسی برای جست‌وجو و مطالعه تعبیر خواب بر اساس منابع و معبران کلاسیک",
        thumbnail = "dream.png",
        technologies = listOf(
            "Kotlin",
            "Android",
            "Jetpack Compose",
            "Material 3",
            "Hilt",
            "DataStore",
            "Coroutines",
            "Flow"
        ),
        status = "Completed",
        githubUrl = "https://github.com/sadeqit/Sadegh-Dream",
        appUrl = "https://cafebazaar.ir/app/io.github.sadeghit.dream",
        featured = true,
        order = 1,
        projectType = ProjectType.Android,
        releaseType = ProjectReleaseType.Released,

        // Project Details
        fullDescription = """
        تعبیر خواب صادق یک اپلیکیشن فارسی برای جست‌وجو و مطالعه تعبیر خواب است که با هدف دسترسی سریع، ساده و منظم به تعبیرهای خواب و مطالب مرتبط توسعه داده شده است.
        کاربران می‌توانند با جست‌وجوی یک کلمه یا موضوع، تعبیرهای مرتبط را پیدا کنند و در محیطی ساده و مناسب مطالعه مشاهده کنند.
        این برنامه همچنین امکان ثبت درخواست تعبیر خواب، ذخیره علاقه‌مندی‌ها و مرور تاریخچه جست‌وجوها را فراهم می‌کند.
    """.trimIndent(),

        goals = listOf(
            "ایجاد مرجعی منظم برای جست‌وجو و مطالعه تعبیر خواب به زبان فارسی",
            "فراهم کردن دسترسی سریع به تعبیرهای مرتبط با موضوع جست‌وجو",
            "تجمیع تعبیرهای برگرفته از منابع و معبران کلاسیک",
            "بهبود تجربه مطالعه با قابلیت‌های شخصی‌سازی متن و ظاهر",
            "فراهم کردن امکان درخواست تعبیر برای موضوعات موجود نبودن در برنامه"
        ),

        features = listOf(
            "جست‌وجوی سریع تعبیر خواب بر اساس کلمه یا موضوع",
            "ارائه تعبیرها بر اساس منابع و معبران کلاسیک از جمله ابن‌سیرین و امام جعفر صادق (ع)",
            "امکان ارسال درخواست تعبیر خواب",
            "افزودن تعبیرها به فهرست علاقه‌مندی‌ها",
            "ذخیره و مرور تاریخچه تعبیرهای مشاهده‌شده",
            "پشتیبانی از حالت روشن و تاریک",
            "شخصی‌سازی ظاهر برنامه",
            "انتخاب نوع قلم",
            "تنظیم اندازه و رنگ متن",
            "تنظیم فاصله خطوط برای مطالعه راحت‌تر"
        ),

        platforms = listOf(
            "Android"
        ),

        architecture = """
    این پروژه با استفاده از Clean Architecture و الگوی MVVM طراحی و توسعه داده شده است.
    ساختار برنامه با هدف جداسازی مسئولیت‌ها، افزایش قابلیت نگهداری و فراهم کردن امکان توسعه و تست بخش‌های مختلف شکل گرفته است.
    رابط کاربری با Jetpack Compose و Material 3 پیاده‌سازی شده است. ViewModelها وضعیت رابط کاربری را مدیریت می‌کنند و ارتباط با داده‌ها از طریق Repository Pattern انجام می‌شود.
    برای مدیریت وابستگی‌ها از Hilt و برای مدیریت تنظیمات برنامه و اطلاعات علاقه‌مندی‌ها از DataStore استفاده شده است.
    همچنین Kotlin Coroutines و Flow برای مدیریت عملیات غیرهمزمان و جریان داده‌ها به کار رفته‌اند.
    """.trimIndent(),

        challenges = listOf(
            ProjectChallenge(
                title = "ایجاد تجربه مطالعه شخصی‌سازی‌شده",
                problem = "کاربران نیازهای متفاوتی در زمینه خوانایی متن و ظاهر محیط مطالعه دارند.",
                solution = "فراهم کردن تنظیمات اختصاصی برای انتخاب قلم، اندازه و رنگ متن و فاصله خطوط."
            ),
            ProjectChallenge(
                title = "مدیریت تنظیمات و علاقه‌مندی‌ها",
                problem = "نیاز به نگهداری تنظیمات شخصی کاربر و دسترسی مجدد به تعبیرهای موردعلاقه.",
                solution = "استفاده از DataStore برای ذخیره تنظیمات برنامه، شخصی‌سازی ظاهر و اطلاعات علاقه‌مندی‌ها."
            ),
            ProjectChallenge(
                title = "سازمان‌دهی اطلاعات و دسترسی سریع",
                problem = "پیدا کردن تعبیرهای مرتبط در میان مجموعه‌ای از موضوعات و مطالب.",
                solution = "طراحی قابلیت جست‌وجو بر اساس کلمه یا موضوع و نمایش نتایج مرتبط در محیطی منظم."
            )
        ),

        screenshots = listOf(
            "dream-01.png",
            "dream-02.png",
            "dream-03.png",
            "dream-04.png",
            "dream-05.png",
            "dream-06.png",
            "dream-07.png",
            "dream-08.png",
            "dream-09.png"
        )
    ),

    Project(
        id = "weatherino",
        title = "ودرینو",
        description = "هواشناسی هوشمند؛ ساخته شده با KMP و طراحی Glassmorphism",
        thumbnail = "weatherino.png",
        technologies = listOf(
            "Kotlin",
            "Kotlin Multiplatform",
            "Compose Multiplatform",
            "Ktor",
            "Koin",
            "SQLDelight"
        ),
        status = "Completed",
        githubUrl = "https://github.com/sadeqit/weatherino",
        appUrl = "https://cafebazaar.ir/app/io.github.sadeqit.weatherino",
        featured = true,
        order = 2,
        projectType = ProjectType.KMP,
        releaseType = ProjectReleaseType.Released,

        // Project Details
        fullDescription = """
        Weatherino یک اپلیکیشن هواشناسی چندسکویی است که با Kotlin Multiplatform و Compose Multiplatform توسعه داده شده است.
        این برنامه اطلاعات آب‌وهوای فعلی، پیش‌بینی وضعیت هوا و کیفیت هوا را در اختیار کاربران قرار می‌دهد. همچنین امکان جستجوی شهرها، دریافت اطلاعات موقعیت مکانی و نگهداری داده‌ها به‌صورت محلی را فراهم می‌کند.
        تمرکز اصلی پروژه بر اشتراک‌گذاری منطق و رابط کاربری بین پلتفرم‌ها، معماری قابل نگهداری و ارائه تجربه کاربری یکپارچه بوده است.
    """.trimIndent(),

        goals = listOf(
            "توسعه یک اپلیکیشن هواشناسی با قابلیت اجرا روی چند پلتفرم",
            "اشتراک‌ گذاری منطق کسب‌وکار و رابط کاربری با Kotlin Multiplatform",
            "ارائه اطلاعات دقیق آب‌وهوا و کیفیت هوا",
            "افزایش پایداری تجربه کاربری با ذخیره‌سازی محلی و پشتیبانی از داده‌های کش‌شده",
            "طراحی رابط کاربری مدرن و یکپارچه با Compose Multiplatform"
        ),

        features = listOf(
            "نمایش وضعیت فعلی آب‌وهوا",
            "پیش‌بینی وضعیت آب‌وهوا",
            "نمایش شاخص کیفیت هوا (AQI)",
            "جستجو و انتخاب شهر",
            "دریافت اطلاعات آب‌وهوا بر اساس موقعیت مکانی در Android",
            "ذخیره محلی اطلاعات آب‌وهوا، پیش‌بینی و کیفیت هوا",
            "ذخیره شهر انتخاب‌شده کاربر",
            "نمایش جزئیاتی مانند دما، رطوبت، سرعت باد، فشار و میزان دید",
            "نمایش زمان طلوع و غروب خورشید",
            "رابط کاربری با الهام از سبک Glassmorphism",
            "پشتیبانی از رابط کاربری راست‌چین"
        ),

        platforms = listOf(
            "Android",
            "Desktop",
            "Web",
        ),

        architecture = """
        Weatherino از معماری Clean Architecture و الگوی MVVM استفاده می‌کند.
        لایه Presentation مسئول رابط کاربری و ViewModelها است. لایه Domain مدل‌ها، Repositoryها و Use Caseها را مدیریت می‌کند. لایه Data نیز ارتباط با سرویس OpenWeatherMap و ذخیره‌سازی محلی را بر عهده دارد.
        برای دریافت اطلاعات از Ktor، برای مدیریت وابستگی‌ها از Koin و برای ذخیره‌سازی داده‌های هواشناسی از SQLDelight استفاده شده است.
        بخش عمده منطق برنامه و رابط کاربری در ماژول shared قرار دارد و پیاده‌سازی قابلیت‌های وابسته به پلتفرم در Source Setهای مربوط به همان پلتفرم انجام می‌شود.
    """.trimIndent(),

        challenges = listOf(
            ProjectChallenge(
                title = "مدیریت وابستگی‌ها در معماری چندسکویی",
                problem = "مدیریت وابستگی‌های مشترک و وابستگی‌های اختصاصی هر پلتفرم در ساختار Kotlin Multiplatform.",
                solution = "استفاده از Koin برای مدیریت Dependency Injection در بخش مشترک و پیاده‌سازی وابستگی‌های اختصاصی در بخش‌های پلتفرمی."
            ),
            ProjectChallenge(
                title = "ذخیره‌سازی محلی اطلاعات آب‌وهوا",
                problem = "نیاز به نگهداری اطلاعات دریافت‌شده برای دسترسی سریع‌تر و استفاده از داده‌ها در شرایط قطع ارتباط اینترنت.",
                solution = "استفاده از SQLDelight برای ذخیره اطلاعات آب‌وهوا، پیش‌بینی و کیفیت هوا و Multiplatform Settings برای نگهداری شهر انتخاب‌شده."
            ),
            ProjectChallenge(
                title = "پیاده‌سازی قابلیت‌های وابسته به پلتفرم",
                problem = "دسترسی به قابلیت‌هایی مانند موقعیت مکانی در محیط‌های اجرایی متفاوت.",
                solution = "استفاده از پیاده‌سازی اختصاصی هر پلتفرم؛ از جمله Google Play Services Location در Android."
            ),
            ProjectChallenge(
                title = "تبدیل پاسخ‌های API به مدل‌های دامنه",
                problem = "مدیریت ساختار پاسخ‌های مختلف OpenWeatherMap و جلوگیری از وابستگی لایه‌های اصلی برنامه به مدل‌های شبکه.",
                solution = "استفاده از DTOها و تبدیل آن‌ها به مدل‌های Domain در لایه Data."
            )
        ),

        screenshots = listOf(
            "android-home.jpg",
            "android-forecast.jpg",
            "android-air-quality.jpg",
            "android-city-selection.jpg",
            "android-drawer.jpg",
            "android-settings.jpg",
            "desktop-home.png"
        )
    ),
)