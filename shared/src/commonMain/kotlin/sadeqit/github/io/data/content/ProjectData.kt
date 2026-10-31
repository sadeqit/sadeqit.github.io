package sadeqit.github.io.data.content

import sadeqit.github.io.domain.model.Project

internal val projectData = listOf(
    Project(
        id = "weatherino",
        title = "Weatherino",
        description = "A modern cross-platform weather application built with Kotlin Multiplatform.",
        thumbnail = null,
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
        order = 1
    ),

    Project(
        id = "sadegh-dream",
        title = "تعبیر خواب صادق",
        description = "A Persian dream interpretation application for Android.",
        thumbnail = null,
        technologies = listOf(
            "Kotlin",
            "Jetpack Compose",
            "Android",
            "Hilt",
            "DataStore"
        ),
        status = "Completed",
        githubUrl = "https://github.com/sadeqit/Sadegh-Dream",
        appUrl = "https://cafebazaar.ir/app/io.github.sadeghit.dream",
        featured = true,
        order = 2
    )
)