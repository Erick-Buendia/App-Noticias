package com.erick.buendia.appnoticias.presenter

interface NewsContract {

    suspend fun getListNews(categories: String)

}