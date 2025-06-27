package ru.vopros.shift.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.vopros.shift.data.model.UserResults

interface UserApi {

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("api/")
    suspend fun fetchUsers(
        @Query("results") results: Int
    ): UserResults

}