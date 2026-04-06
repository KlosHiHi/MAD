package com.example.lesson0406.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto (
    val id: String,
    @SerialName("img_src")
    val imgSrc: String
)

