package com.example.lesson0406.data

import retrofit2.http.GET

interface MarsApi {
    @GET("/photos")
    suspend fun getPhotos(): List<MarsPhoto>
}