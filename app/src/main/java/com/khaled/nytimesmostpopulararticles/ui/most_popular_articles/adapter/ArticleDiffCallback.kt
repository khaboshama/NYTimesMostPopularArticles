package com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.adapter

import androidx.recyclerview.widget.DiffUtil
import com.khaled.nytimesmostpopulararticles.model.Article

class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(oldItem: Article, newItem: Article) = oldItem === newItem

    override fun areContentsTheSame(oldItem: Article, newItem: Article) = oldItem.id == newItem.id
}