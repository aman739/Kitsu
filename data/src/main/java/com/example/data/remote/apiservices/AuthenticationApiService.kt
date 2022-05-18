package com.example.data.remote.apiservices

import com.example.data.remote.dtos.authorization.AuthDto
import com.example.data.remote.dtos.authorization.TokenDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApiService {
    @POST("token")
    suspend fun authenticate(
        @Body authDto: AuthDto

    ): TokenDto
}