package com.khaled.nytimesmostpopulararticles.model.repository

import androidx.lifecycle.LiveData
import com.khaled.nytimesmostpopulararticles.model.ArticleItem
import com.khaled.nytimesmostpopulararticles.utils.SingleLiveEvent

interface ArticleRepositoryContract {
    suspend fun loadMostPopularArticleList()
    fun getMostPopularArticleList(): LiveData<List<ArticleItem>>
    fun getErrorMessage(): SingleLiveEvent<String>
}