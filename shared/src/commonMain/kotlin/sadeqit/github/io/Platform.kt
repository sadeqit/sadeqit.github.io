package sadeqit.github.io

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform