package com.example.database

import com.example.model.User
import org.litote.kmongo.getCollection

object Entries {
    val dbUser = DatabaseConnection.database.getCollection<User>("User")
}