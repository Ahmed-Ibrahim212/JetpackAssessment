package com.example.jetpackcomposeassess.data.repository

import com.example.jetpackcomposeassess.ApiService
import com.example.jetpackcomposeassess.data.model.Model
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(private val api: ApiService) {
    suspend fun getUserInfo(): Response<Model>{
        return api.getUser()
    }
}