package com.example.resource

import com.example.database.Entries
import com.example.model.User
import com.example.responses.DefaultResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.litote.kmongo.*


fun Route.createUser(){
    post("/createUser") {
        val userData = call.receive<User>()
        println(userData)


        /** create user*/
        val result = try {
            Entries.dbUser.insertOne(userData).wasAcknowledged()
        }catch (e:Exception){
            e.printStackTrace()
            false
        }
        if (result){
            call.respond(
                status = HttpStatusCode.OK,
                message = DefaultResponse(
                    status = true,
                    message = "User created successfully"
                )
            )
        }else{
            call.respond(
                status = HttpStatusCode.OK,
                message = DefaultResponse(
                    status = false,
                    message = "failed to create user"
                )
            )
        }
    }
}
fun Route.updateUser(){
    post("/updateUser/{id?}"){
        val id = call.parameters["id"] ?: call.respond(message = DefaultResponse(message = "Include parameters in your request"))
        val userdata = call.receive<User>()
        println(userdata)
        val result = try {
            val getUser = Entries.dbUser.findOne(User::userId eq id)
            val updateData = getUser?.copy(
                firstName = userdata.firstName,
                lastName = userdata.lastName,
                age = userdata.age,
                gender = userdata.gender
            )
            if (updateData != null) {
                Entries.dbUser.updateOne(User::userId eq id , updateData).wasAcknowledged()
            } else {

            }
        }catch (e:Exception){
            e.printStackTrace()
            false
        }
        if (result == true){
            call.respond(
                status = HttpStatusCode.OK,
                message = DefaultResponse(
                    status = true,
                    message = "User updated successfully"
                )
            )
        }else{
            call.respond(
                status = HttpStatusCode.OK,
                message = DefaultResponse(
                    status = false,
                    message = "failed to update user"
                )
            )
        }

    }
}
fun Route.getUser(){
    get("/getUser/{id?}"){
        val id = call.parameters["id"]?: call.respond(message = DefaultResponse(message = "Include parameters in your request"))
        val result = try {
            Entries.dbUser.findOne(User::userId eq id )
        }catch (e:Exception){
            e.printStackTrace()
            null
        }
        if (result != null){
            call.respond(
                status = HttpStatusCode.OK,
                message = result
            )
        }else{
            call.respond(
                status = HttpStatusCode.OK,
                message = DefaultResponse(
                    status = false,
                    message = "failed to get user"
                )
            )
        }

    }

}
fun Route.deleteUser(){
    get("deleteUser/{id?}") {
        val id = call.parameters["id"]?: call.respond(message = DefaultResponse(message = "Include parameters in your request"))

        val result = try {
            Entries.dbUser.deleteOne(User::userId eq id)
        }catch (e:Exception){
            e.printStackTrace()
            null
        }
        if (result != null){
            call.respond(
                status = HttpStatusCode.OK,
                message = DefaultResponse(
                    status = false,
                    message = "User was deleted successfully"
                )
            )
        }else{
            call.respond(
                status = HttpStatusCode.OK,
                message = DefaultResponse(
                    status = false,
                    message = "failed to delete user"
                )
            )
        }
    }
}