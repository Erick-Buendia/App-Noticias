package com.erick.buendia.appnoticias.view.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erick.buendia.appnoticias.R
import com.erick.buendia.appnoticias.data.model.Article

class NewsAdapter(private val newsList: List<Article>, private val onClickNewsListener: (Article) ->Unit) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(
            inflater.inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsList[position]
        holder.render(item, onClickNewsListener)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }


}