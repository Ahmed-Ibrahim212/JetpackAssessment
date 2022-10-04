package com.example.jetpackcomposeassess.view

import android.content.Context
import com.example.jetpackcomposeassess.data.model.Model
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiService {

    @GET("api")
    suspend fun getUser(): Response<Model>



    companion object {

        fun create(context: Context): ApiService {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httplClient: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.MINUTES)
                .writeTimeout(30, TimeUnit.MINUTES) // write timeout
                .readTimeout(30, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httplClient)
                .baseUrl("https://randomuser.me/")
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}