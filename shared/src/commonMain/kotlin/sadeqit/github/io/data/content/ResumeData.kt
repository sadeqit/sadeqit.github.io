package sadeqit.github.io.data.content

import sadeqit.github.io.domain.model.ResumeContent
import sadeqit.github.io.domain.model.ResumeExperience
import sadeqit.github.io.domain.model.ResumeProject
import sadeqit.github.io.domain.model.ResumeSkillCategory
import sadeqit.github.io.domain.model.ResumeSocialLink

val resumeContent = ResumeContent(
    fullName = "صادق آی تی | برنامه نویس اندروید",
    summary = """
    توسعه‌دهنده اندروید و Kotlin Multiplatform با بیش از ۴ سال سابقه توسعه مستقل نرم‌افزار.
    
    سازنده اپلیکیشن‌ های مدرن و مقیاس‌ پذیر با Kotlin و Jetpack Compose، مبتنی بر MVVM، معماری تمیز (Clean Architecture)، اصول SOLID و Clean Code.
    
    دارای تجربه عملی در طراحی رابط کاربری، یکپارچه‌ سازی REST API، برنامه‌ نویسی ناهمگام با Coroutines و Flow، ذخیره‌سازی محلی، تزریق وابستگی (DI) و توسعه چندسکویی.
    
    با تجربه مدیریت چرخه عمر اپلیکیشن‌های اندرویدی، از طراحی و پیاده‌سازی تا انتشار در مارکت‌ های اپلیکیشن و نگهداری؛ با تمرکز بر بهینه‌ سازی عملکرد، کیفیت کد و تجربه کاربری.
""".trimIndent(),

    skills = listOf(
        ResumeSkillCategory(
            title = "زبان برنامه نویسی و همزمانی",
            skills = listOf(
                "Kotlin",
                "Coroutines",
                "Flow",
                "StateFlow",
                "SharedFlow",
                "Kotlin Serialization",
            ),
        ),
        ResumeSkillCategory(
            title = "توسعه اندروید و چندسکویی",
            skills = listOf(
                "Android SDK",
                "Jetpack Compose",
                "Material 3",
                "Navigation Compose",
                "Kotlin Multiplatform (KMP)",
                "Compose Multiplatform",
                "Kotlin/Wasm",
            ),
        ),
        ResumeSkillCategory(
            title = "معماری و اصول طراحی",
            skills = listOf(
                "MVVM",
                "Clean Architecture",
                "SOLID",
                "Design Patterns",
                "Clean Code",
            ),
        ),
        ResumeSkillCategory(
            title = "شبکه و ذخیره‌سازی داده",
            skills = listOf(
                "REST APIs",
                "Ktor",
                "Retrofit",
                "Error Handling",
                "Room",
                "DataStore",
                "SQLDelight",
                "Supabase",
            ),
        ),
        ResumeSkillCategory(
            title = "تزریق وابستگی",
            skills = listOf(
                "Dagger Hilt",
                "Koin",
            ),
        ),
        ResumeSkillCategory(
            title = "رابط کاربری و تجربه کاربری",
            skills = listOf(
                "Material Design",
                "Design System",
                "Responsive Design",
                "Adaptive Layout",
                "Light/Dark Theme",
                "Animation & Motion",
            ),
        ),
        ResumeSkillCategory(
            title = "تست و کیفیت",
            skills = listOf(
                "Unit Testing",
                "Debugging",
                "Performance Optimization",
            ),
        ),
        ResumeSkillCategory(
            title = "کنترل نسخه و گردش کار",
            skills = listOf(
                "Git",
                "GitHub",
                "Git Flow",
                "Release Management",
                "CI/CD",
                "GitHub Actions",
            ),
        )
    ),

    experiences = listOf(
        ResumeExperience(
            title = "توسعه‌دهنده مستقل اندروید - از سال 1400 تا کنون",
            description = """
            🔹توسعه و انتشار مستقل اپلیکیشن‌های اندرویدی با Kotlin
            
            🔹از پیاده‌ سازی قابلیت‌ها تا بهینه‌سازی و نگهداری نرم‌افزار
            
            🔹مدیریت کامل چرخه توسعه؛ از طراحی تا انتشار در مارکت ها
        """.trimIndent(),
        ),
    ),

    projects = listOf(
        ResumeProject(
            name = "ودرینو - هواشناسی هوشمند",
            description = """
        اپلیکیشن هواشناسی چندسکویی با قابلیت نمایش وضعیت لحظه‌ای آب‌وهوا، پیش‌بینی هوا، اطلاعات کیفیت هوا و جست‌وجوی شهرها؛
        با پشتیبانی از موقعیت مکانی، ذخیره‌سازی محلی و دسترسی آفلاین به آخرین اطلاعات دریافت شده. برای پلتفرم‌های موبایل، دسکتاپ و وب.
    """.trimIndent(),
            technologies = listOf(
                "Kotlin",
                "Kotlin Multiplatform",
                "Compose Multiplatform",
                "Material 3",
                "MVVM",
                "Clean Architecture",
                "Ktor",
                "Koin",
                "SQLDelight",
            ),
            githubUrl = "https://github.com/sadeqit/weatherino",
            appUrl = "https://cafebazaar.ir/app/io.github.sadeqit.weatherino",
            projectId = "weatherino",
        ),
        ResumeProject(
            name = "تعبیر خواب صادق",
            description = """
        اپلیکیشن اندرویدی جست‌وجو و مطالعه تعبیر خواب بر اساس منابع و معبران کلاسیک، با قابلیت ثبت درخواست تعبیر، مدیریت علاقه‌مندی‌ ها، تاریخچه و شخصی‌سازی تجربه مطالعه.
    """.trimIndent(),
            technologies = listOf(
                "Kotlin",
                "Android",
                "Jetpack Compose",
                "Material 3",
                "MVVM",
                "Clean Architecture",
                "Hilt",
                "DataStore",
            ),
            githubUrl = "https://github.com/sadeqit/weatherino",
            appUrl = "https://cafebazaar.ir/app/io.github.sadeghit.dream",
            projectId = "sadegh-dream",
        ),
        ResumeProject(
            name = "Online Shop",
            description = """
        اپلیکیشن فروشگاه آنلاین اندرویدی با قابلیت احراز هویت کاربران، جست‌وجو و دسته‌بندی محصولات، سبد خرید، علاقه‌مندی‌ها، ثبت و پیگیری سفارش‌ها و مدیریت پروفایل و آدرس‌ها، با Backend مبتنی بر Supabase.
    """.trimIndent(),
            technologies = listOf(
                "Kotlin",
                "Android",
                "Jetpack Compose",
                "Material 3",
                "MVVM",
                "Clean Architecture",
                "Hilt",
                "Supabase",
                "PostgreSQL",
                "DataStore",
                "Coil",
            ),
            githubUrl = "https://github.com/sadeqit/Online-Shop",
        ),
    ),


    socialLinks = listOf(
        ResumeSocialLink(
            title = "Email",
            url = "mailto:danayankalam@gmail.com",
        ),
        ResumeSocialLink(
            title = "GitHub",
            url = "https://github.com/sadeqit",
        ),
        ResumeSocialLink(
            title = "LinkedIn",
            url = "https://www.linkedin.com/in/sadegh-it-2578a0218",
        ),
        ResumeSocialLink(
            title = "Telegram",
            url = "https://t.me/DANAYAN_KALAM",
        ),
        ResumeSocialLink(
            title = "Instagram",
            url = "https://www.instagram.com/sadegh.it",
        )
    ),
)