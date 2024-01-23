package com.example.messaging_database

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform