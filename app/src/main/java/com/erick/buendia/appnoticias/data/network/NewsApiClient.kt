package com.erick.buendia.appnoticias.data.network

import com.erick.buendia.appnoticias.data.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiClient {

    //Peteciones a la  API
    @GET("news")
    suspend fun getAllNews(
        @Query("access_key") apiKey: String,  @Query("languages") language: String,  @Query("categories") categories: String
    ): Response<News>
}