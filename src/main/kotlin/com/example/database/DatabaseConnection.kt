package com.example.database

import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

object DatabaseConnection {
    /** MongoDd Client Instance*/
    private val client = KMongo.createClient("mongodb+srv://pascarl:pasaka001@coinx.lif2vaj.mongodb.net/")
    /** Database Instantiation of client*/
    val database: MongoDatabase = client.getDatabase("Digitalent")
}