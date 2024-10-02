package com.erick.buendia.appnoticias.view.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erick.buendia.appnoticias.R
import com.erick.buendia.appnoticias.data.NewsApi
import com.erick.buendia.appnoticias.data.model.Article
import com.erick.buendia.appnoticias.databinding.FragmentBusinessBinding
import com.erick.buendia.appnoticias.databinding.FragmentGeneralBinding
import com.erick.buendia.appnoticias.presenter.NewsPresenter
import com.erick.buendia.appnoticias.view.adaptar.NewsAdapter
import kotlinx.coroutines.launch

class FragmentBusiness : Fragment(), FragmentGeneralContract {

    private  var _binding: FragmentBusinessBinding? = null
    private val binding get()  = _binding!!
    private lateinit var recyclerView: RecyclerView
    private val presenterNews = NewsPresenter(this, NewsApi())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBusinessBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch() {
            presenterNews.getListNews("business")
        }
    }

    override suspend fun showNews(article: List<Article>) {
        initRecycleView(article)
    }

    override fun errorCallListNews() {
        Toast.makeText(context, "Error al cargar las noticias", Toast.LENGTH_SHORT).show()
    }

    private fun initRecycleView(movies: List<Article>) {
        recyclerView = binding.rvBusiness
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = NewsAdapter(movies,onClickNewsListener ={
                news -> navigateToDetailNews(news)
        })
        binding.lyLoadingBusiness.isVisible = false
        binding.rvBusiness.isVisible = true

    }

    private fun  navigateToDetailNews(news: Article){
        findNavController().navigate(FragmentBusinessDirections.actionFragmentBusinessToNewsDetailActivity(news))
    }

}