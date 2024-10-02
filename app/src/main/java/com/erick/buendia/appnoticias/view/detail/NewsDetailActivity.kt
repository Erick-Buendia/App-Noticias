package com.erick.buendia.appnoticias.view.detail


import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs

import com.bumptech.glide.Glide
import com.erick.buendia.appnoticias.R
import com.erick.buendia.appnoticias.data.model.Article
import com.erick.buendia.appnoticias.databinding.ActivityNewsDetailBinding
import java.util.Locale

class NewsDetailActivity : AppCompatActivity() {


    val safeArguments: NewsDetailActivityArgs by navArgs()
    private lateinit var binding: ActivityNewsDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.topAppBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val article: Article? = safeArguments.news
        renderView(article)
    }


    private fun renderView(article: Article?) {
        var dateString = article?.publishedAt
        val date = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse(dateString).toString()
        dateString = date.split("00")[0]
        binding.detailTitle.text = article?.title
        binding.detailDescription.text = article?.description
        binding.detailDate.text = dateString
        binding.detailSource.text = article?.source
        if (article?.image.isNullOrEmpty()) {
            binding.detailImage.setImageResource(R.drawable.noticia)
        } else {
            Glide.with(binding.detailImage.context)
                .load(article?.image).into(binding.detailImage)
        }
    }


}