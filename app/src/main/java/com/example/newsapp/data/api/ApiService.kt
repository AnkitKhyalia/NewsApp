package com.example.newsapp.data.api

import com.example.newsapp.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country:String,
        @Query("apiKey") apiKey: String="a0e3714871ff4867b4d334e82ab97700"
    ):Response<NewsResponse>
}
//GET https://newsapi.org/v2/top-headlines?country=us&apiKey=a0e3714871ff4867b4d334e82ab97700