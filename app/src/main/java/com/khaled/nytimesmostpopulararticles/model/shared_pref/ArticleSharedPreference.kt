package com.khaled.nytimesmostpopulararticles.model.shared_pref

import android.content.Context
import android.content.SharedPreferences
import com.khaled.nytimesmostpopulararticles.constant.Constants

class ArticleSharedPreference private constructor(context: Context) :
    ArticleSharedPreferenceContract {

    private val sharedPreference: SharedPreferences = context.getSharedPreferences(
        Constants.MOST_POPULAR_ARTICLES_SHARED_PREFERENCE,
        Context.MODE_PRIVATE
    )

    override fun updateLastCachedArticleDate(milliSeconds: Long) {
        sharedPreference.edit().putLong(Constants.LAST_CACHED_ARTICLES_DATE_KEY, milliSeconds)
            .apply()
    }

    override fun getLastCachedArticleDate() =
        sharedPreference.getLong(
            Constants.LAST_CACHED_ARTICLES_DATE_KEY,
            Constants.DEFAULT_DATE_MILLISECONDS
        )

    companion object {
        private var instance: ArticleSharedPreferenceContract? = null
        fun getInstance(context: Context): ArticleSharedPreferenceContract? {
            if (instance == null) instance = ArticleSharedPreference(context)
            return instance
        }
    }
}
