package com.erick.buendia.appnoticias.view.news

import com.erick.buendia.appnoticias.data.model.Article

interface FragmentGeneralContract {

    suspend fun showNews(article:List<Article>)

    fun errorCallListNews()
}