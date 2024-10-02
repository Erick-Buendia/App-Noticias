package com.erick.buendia.appnoticias.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Article(
    @SerializedName("author")
    val author: String?,
    @SerializedName("category")
    val category: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("language")
    val language: String,
    @SerializedName("published_at")
    val publishedAt: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
) : Parcelable