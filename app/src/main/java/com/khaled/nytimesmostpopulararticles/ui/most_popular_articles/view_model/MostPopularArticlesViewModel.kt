package com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.view_model

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khaled.nytimesmostpopulararticles.R
import com.khaled.nytimesmostpopulararticles.base.BaseViewModel
import com.khaled.nytimesmostpopulararticles.constant.Constants
import com.khaled.nytimesmostpopulararticles.model.Article
import com.khaled.nytimesmostpopulararticles.model.network.RetrofitService
import com.khaled.nytimesmostpopulararticles.model.response.ArticleListResponse
import com.khaled.nytimesmostpopulararticles.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import retrofit2.Response

class MostPopularArticlesViewModel(application: Application) : BaseViewModel(application) {

    var articleList = MutableLiveData<List<Article>>()
        private set

    var navigateToArticleScreenLiveData = SingleLiveEvent<Article>()
        private set

    fun loadArticleList() {
        viewModelScope.launch {
            try {
                val articleListResponse =
                    RetrofitService.mostPopularServiceApi.getMostPopularArticles(
                        Constants.MOST_ARTICLE_PERIOD,
                        Constants.API_KEY
                    )
                if (articleListResponse.isSuccessful) {
                    parseArticleListSuccessResponse(articleListResponse)
                } else {
                    parseArticleListErrorResponse()
                }
            } catch (e: Exception) {
                parseArticleListErrorResponse()
            }
        }
    }

    private fun parseArticleListSuccessResponse(articleListResponse: Response<ArticleListResponse>) {
        articleList.value = articleListResponse.body()?.articleList
    }

    private fun parseArticleListErrorResponse() {
        showMessage.value = getApplication<Application>().getString(R.string.error_message)
    }

    fun onArticleClicked(position: Int) {
        navigateToArticleScreenLiveData.value = articleList.value?.get(position)
    }
}