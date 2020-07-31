package com.kekmech

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.Compression
import io.ktor.features.DefaultHeaders
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.util.toMap

fun main(args: Array<String>) {
    embeddedServer(Netty, port = GlobalConfig.port) {
        install(DefaultHeaders)
        install(Compression)
        install(CallLogging)

        routing {
            get("/") {
                call.respondText(ContentType.Text.Plain, HttpStatusCode.OK) {
                    call.request.headers
                        .toMap()
                        .toList()
                        .joinToString("\n") { it.first + ": " + it.second }
                }
            }
            post("/") {
                call.respondText(ContentType.Text.Plain, HttpStatusCode.OK) {
                    call.request.headers
                        .toMap()
                        .toList()
                        .joinToString("\n") { it.first + ": " + it.second }
                }
            }
        }
    }
}