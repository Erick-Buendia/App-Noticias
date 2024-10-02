package com.erick.buendia.appnoticias.data

import com.erick.buendia.appnoticias.data.model.Article

interface NewsModelContract {
    suspend fun getArticles(categories:String) : List<Article>?
}