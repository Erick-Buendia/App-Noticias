package com.erick.buendia.appnoticias.data.network

import com.erick.buendia.appnoticias.BuildConfig
import com.erick.buendia.appnoticias.core.RetrofitHelper
import com.erick.buendia.appnoticias.data.model.Article
import com.erick.buendia.appnoticias.data.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class NewsService {

    //Ejecutamos la peticion atraves de Retrofit en un hilo secundario en un corrutina
    suspend fun getNews(categories: String): News {
        return withContext(Dispatchers.IO) {
            val response = RetrofitHelper.provideRetrofit().create(NewsApiClient::class.java)
                .getAllNews(BuildConfig.API_KEY, "es", categories)
            response.body()!!
        }
    }


}