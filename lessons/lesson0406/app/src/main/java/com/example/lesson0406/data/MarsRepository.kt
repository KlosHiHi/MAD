package com.example.lesson0406.data


class MarsRepository {
    val api: MarsApi = RetrofitHelper.getInstance().create(MarsApi::class.java)

    suspend fun getMarsPhotos(): List<MarsPhoto>{
        return api.getPhotos()
    }
}