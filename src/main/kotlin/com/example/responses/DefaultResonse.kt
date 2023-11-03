package com.example.responses

import kotlinx.serialization.Serializable

@Serializable
data class DefaultResponse(
    val status:Boolean = false,
    val message:String
)