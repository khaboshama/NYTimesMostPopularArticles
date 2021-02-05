package com.khaled.nytimesmostpopulararticles.ui.article_details

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.khaled.nytimesmostpopulararticles.R
import com.khaled.nytimesmostpopulararticles.constant.Constants
import com.khaled.nytimesmostpopulararticles.databinding.ActivityArticleDetailsBinding
import com.khaled.nytimesmostpopulararticles.model.Article

class ArticleDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_article_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        parseExtraIntentData()
        binding.backArrowImageView.setOnClickListener { finish() }
    }

    private fun parseExtraIntentData() {
        val article = intent.getParcelableExtra<Article>(Constants.INTENT_ARTICLE_KEY)
        article?.let {
            Glide.with(this).load(article.mediaList[0].mediaMetaDataList[2].url)
                .placeholder(R.drawable.ic_place_holder).into(binding.originalImageView)
            binding.titleTextView.text = article.title
            binding.authorTextView.text = article.byline
            binding.dateTextView.text = article.publishedDate
            binding.descriptionTextView.text = article.description
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}