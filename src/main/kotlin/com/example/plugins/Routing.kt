package com.example.plugins

import com.example.resource.createUser
import com.example.resource.deleteUser
import com.example.resource.getUser
import com.example.resource.updateUser
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")

        }
        createUser()
        getUser()
        deleteUser()
        updateUser()
    }
}
