package com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.khaled.nytimesmostpopulararticles.R
import com.khaled.nytimesmostpopulararticles.constant.Constants
import com.khaled.nytimesmostpopulararticles.databinding.ActivityMostPopularArticlesBinding
import com.khaled.nytimesmostpopulararticles.ui.article_details.ArticleDetailsActivity
import com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.adapter.ArticleListAdapter
import com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.view_model.MostPopularArticlesViewModel

class MostPopularArticlesActivity : AppCompatActivity() {

    private lateinit var articleListAdapter: ArticleListAdapter
    private lateinit var binding: ActivityMostPopularArticlesBinding
    private lateinit var viewModel: MostPopularArticlesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_most_popular_articles)
        viewModel = ViewModelProvider(this).get(MostPopularArticlesViewModel::class.java)
        setupArticlesRecyclerView()
        setupObservers()
        viewModel.loadArticleList()
    }

    private fun setupObservers() {
        viewModel.articleList.observe(this) {
            hideProgressBar()
            articleListAdapter.submitList(it)
        }
        viewModel.showMessage.observe(this) {
            hideProgressBar()
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        viewModel.navigateToArticleScreenLiveData.observe(this) {
            startActivity(Intent(this, ArticleDetailsActivity::class.java).apply {
                putExtra(Constants.INTENT_ARTICLE_KEY, it)
            })
        }
    }

    private fun hideProgressBar() {
        binding.loadingProgressBar.visibility = View.GONE
    }

    private fun setupArticlesRecyclerView() {
        articleListAdapter = ArticleListAdapter(this)
        binding.articlesRecyclerView.adapter = articleListAdapter
    }
}