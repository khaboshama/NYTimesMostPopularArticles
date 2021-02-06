package com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.adapter

import androidx.recyclerview.widget.DiffUtil
import com.khaled.nytimesmostpopulararticles.model.Article
import com.khaled.nytimesmostpopulararticles.model.ArticleItem

class ArticleItemDiffCallback : DiffUtil.ItemCallback<ArticleItem>() {

    override fun areItemsTheSame(oldItem: ArticleItem, newItem: ArticleItem) = oldItem === newItem

    override fun areContentsTheSame(oldItem: ArticleItem, newItem: ArticleItem) = oldItem.id == newItem.id
}