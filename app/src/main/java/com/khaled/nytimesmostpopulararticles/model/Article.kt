package com.khaled.nytimesmostpopulararticles.model

import androidx.annotation.NonNull
import com.google.gson.annotations.SerializedName

data class Article(
    @NonNull
    val id: Long,
    @SerializedName("published_date")
    val publishedDate: String?,
    val byline: String?,
    val title: String?,
    @SerializedName("abstract")
    val description: String?,
    @SerializedName("media")
    val mediaList: List<Media>
)