package com.erick.buendia.appnoticias.presenter

import com.erick.buendia.appnoticias.data.NewsModelContract
import com.erick.buendia.appnoticias.view.news.FragmentGeneralContract

class NewsPresenter(
    private val mainView: FragmentGeneralContract,
    private val apiService: NewsModelContract
) : NewsContract {
    //El view llama al presenter que llama a la api y devuelve la lista de noticias
    //La lista de noticias se devuelve al view

    override suspend fun getListNews(categories: String) {
        val articles = apiService.getArticles(categories)
        if (articles != null) {
            mainView.showNews(articles)
        } else {
            mainView.errorCallListNews()
        }
    }
}