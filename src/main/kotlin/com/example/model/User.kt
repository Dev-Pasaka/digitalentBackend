package com.example.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.UUID

@Serializable
data class User(
    @BsonId
    val userId:String = ObjectId().toString(),
    val firstName:String,
    val lastName:String,
    val age:Int,
    val town:String,
    val gender:Gender
)
