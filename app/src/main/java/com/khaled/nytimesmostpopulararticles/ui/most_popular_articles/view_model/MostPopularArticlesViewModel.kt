package com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.view_model

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.khaled.nytimesmostpopulararticles.base.BaseViewModel
import com.khaled.nytimesmostpopulararticles.model.ArticleItem
import com.khaled.nytimesmostpopulararticles.model.repository.ArticleRepository
import com.khaled.nytimesmostpopulararticles.model.repository.ArticleRepositoryContract
import com.khaled.nytimesmostpopulararticles.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class MostPopularArticlesViewModel(application: Application) : BaseViewModel(application) {


    var navigateToArticleScreenLiveData = SingleLiveEvent<ArticleItem>()
        private set

    var articleRepository: ArticleRepositoryContract = ArticleRepository(application)

    var articleList = articleRepository.getMostPopularArticleList()
        private set

    private var showRepositoryMessage = articleRepository.getErrorMessage()
    override val showMessage = showRepositoryMessage

    fun loadArticleList() {
        viewModelScope.launch { articleRepository.loadMostPopularArticleList() }
    }

    fun onArticleClicked(position: Int) {
        navigateToArticleScreenLiveData.value = articleList.value?.get(position)
    }
}