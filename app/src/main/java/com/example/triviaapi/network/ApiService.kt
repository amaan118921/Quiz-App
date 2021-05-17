package com.example.triviaapi.network

import com.example.triviaapi.JsonResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://opentdb.com/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retorfit= Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
    BASE_URL).build()

interface ApiService {
    @GET("api.php")
    suspend fun getQuestions(@Query("type")Type: String, @Query("difficulty")Difficulty:String,
                             @Query("category")Category: Int , @Query("amount")Amount: Int) : JsonResponse
}

object Api {
    val retrofitService: ApiService by lazy { retorfit.create(ApiService::class.java) }
}


