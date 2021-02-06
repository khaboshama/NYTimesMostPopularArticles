package com.khaled.nytimesmostpopulararticles.model.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.khaled.nytimesmostpopulararticles.R
import com.khaled.nytimesmostpopulararticles.constant.Constants
import com.khaled.nytimesmostpopulararticles.model.ArticleItem
import com.khaled.nytimesmostpopulararticles.model.database.NYTimesMostPopularArticlesDatabase
import com.khaled.nytimesmostpopulararticles.model.network.RetrofitService
import com.khaled.nytimesmostpopulararticles.model.shared_pref.ArticleSharedPreference
import com.khaled.nytimesmostpopulararticles.utils.DateUtils.isBeforeToday
import com.khaled.nytimesmostpopulararticles.utils.SingleLiveEvent

class ArticleRepository(private val context: Context) : ArticleRepositoryContract {

    private var articles: LiveData<List<ArticleItem>> = NYTimesMostPopularArticlesDatabase.getInstance(context)?.getArticleDAO()?.getMostPopularArticleList()!!
    private var errorMessage: SingleLiveEvent<String> = SingleLiveEvent()

    override suspend fun loadMostPopularArticleList() {
        try {
            val lastTimeCachedTime = ArticleSharedPreference.getInstance(context)?.getLastCachedArticleDate() ?: Constants.DEFAULT_DATE_MILLISECONDS
            if (lastTimeCachedTime == Constants.DEFAULT_DATE_MILLISECONDS || isBeforeToday(lastTimeCachedTime)) {
                val articleListResponse = RetrofitService.mostPopularServiceApi.getMostPopularArticles(Constants.MOST_ARTICLE_PERIOD, Constants.API_KEY)
                val list = articleListResponse.articleList.map { article ->
                    ArticleItem(
                        article.id,
                        article.publishedDate,
                        article.byline,
                        article.title,
                        article.description,
                        article.mediaList[0].mediaMetaDataList[2].url
                    )
                }
                NYTimesMostPopularArticlesDatabase.getInstance(context)?.getArticleDAO()?.deleteAll()
                NYTimesMostPopularArticlesDatabase.getInstance(context)?.getArticleDAO()?.insertAll(
                    *list.map { it }.toTypedArray()
                )
                ArticleSharedPreference.getInstance(context)?.updateLastCachedArticleDate(System.currentTimeMillis())
            }
        } catch (e: Exception) {
            errorMessage.value = e.message ?: context.getString(R.string.error_message)
        }
    }

    override fun getMostPopularArticleList() = articles
    override fun getErrorMessage() = errorMessage
}