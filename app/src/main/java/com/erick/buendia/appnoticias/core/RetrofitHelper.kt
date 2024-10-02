package com.erick.buendia.appnoticias.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
object RetrofitHelper {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.mediastack.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}