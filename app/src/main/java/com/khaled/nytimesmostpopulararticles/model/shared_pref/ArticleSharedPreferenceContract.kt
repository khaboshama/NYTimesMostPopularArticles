package com.khaled.nytimesmostpopulararticles.model.shared_pref

interface ArticleSharedPreferenceContract {
    fun updateLastCachedArticleDate(milliSeconds: Long)
    fun getLastCachedArticleDate(): Long
}