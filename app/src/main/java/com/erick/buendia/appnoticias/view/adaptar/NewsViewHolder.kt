package com.erick.buendia.appnoticias.view.adaptar

import android.icu.text.SimpleDateFormat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erick.buendia.appnoticias.R
import com.erick.buendia.appnoticias.data.model.Article
import com.erick.buendia.appnoticias.databinding.ItemNewsBinding
import java.util.Locale


class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemNewsBinding.bind(view)

    fun render(item: Article, onClickNewsListener: (Article) -> Unit) {
        var dateString = item.publishedAt
        val date = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse(dateString).toString()
        dateString = date.split("00")[0]
        binding.tvTitle.text = item.title
        binding.tvDate.text = dateString

        binding.tvSource.text = (item.source).uppercase()
        if (item.image != null) {
            Glide.with(binding.ivNews.context)
                .load(item.image).into(binding.ivNews)
        } else {
            Glide.with(binding.ivNews.context).clear(binding.ivNews);
            binding.ivNews.setImageResource(R.drawable.noticia)
        }
        itemView.setOnClickListener { onClickNewsListener(item) }
    }


}