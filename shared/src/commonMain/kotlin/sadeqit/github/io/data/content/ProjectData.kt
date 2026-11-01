package sadeqit.github.io.data.content

import sadeqit.github.io.domain.model.Project

internal val projectData = listOf(

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
        order = 2
    ),

    Project(
        id = "sadegh-dream",
        title = "تعبیر خواب صادق",
        description = "مرجعی برای تعبیر خواب ها با تکیه بر منابع معتبر",
        thumbnail = "dream.png",
        technologies = listOf(
            "Kotlin",
            "Android",
            "Jetpack Compose",
            "Hilt",
            "DataStore"
        ),
        status = "Completed",
        githubUrl = "https://github.com/sadeqit/Sadegh-Dream",
        appUrl = "https://cafebazaar.ir/app/io.github.sadeghit.dream",
        featured = true,
        order = 1
    ),
    )