package com.erick.buendia.appnoticias.data


import android.util.Log
import com.erick.buendia.appnoticias.data.model.Article
import com.erick.buendia.appnoticias.data.network.NewsService


class NewsApi: NewsModelContract {

    private val apiService = NewsService()

    override suspend fun getArticles(categories:String): List<Article>? {
        runCatching {  apiService.getNews(categories) }
            .onSuccess {
                return it.data
            }.onFailure {
                Log.i("ErrorNewsApi", it.message.toString())
            }
        return null
    }
}