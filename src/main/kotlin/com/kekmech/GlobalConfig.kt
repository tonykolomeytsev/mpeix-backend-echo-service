package com.kekmech

object GlobalConfig {
    val port = System.getenv("PORT")?.toIntOrNull() ?: 8081
}