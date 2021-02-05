package com.khaled.nytimesmostpopulararticles.model.response

import com.google.gson.annotations.SerializedName
import com.khaled.nytimesmostpopulararticles.model.Article

data class ArticleListResponse(@SerializedName("results") val articleList: List<Article>)