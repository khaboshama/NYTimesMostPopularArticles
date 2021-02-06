package com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khaled.nytimesmostpopulararticles.R
import com.khaled.nytimesmostpopulararticles.databinding.ListItemArticleBinding
import com.khaled.nytimesmostpopulararticles.model.ArticleItem
import com.khaled.nytimesmostpopulararticles.ui.most_popular_articles.view_model.MostPopularArticlesViewModel
import com.khaled.nytimesmostpopulararticles.utils.convertDpToPixels

class ArticleListAdapter(context: Context) :
    ListAdapter<ArticleItem, ArticleListAdapter.ArticleViewHolder>(ArticleItemDiffCallback()) {

    private var viewModel =
        ViewModelProvider((context as AppCompatActivity)).get(MostPopularArticlesViewModel::class.java)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding =
            ListItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = getItem(position)
        val context = holder.thumbnailImageView.context
        val height = convertDpToPixels(
            context,
            context.resources.getDimension(R.dimen.thumbnail_height)
        ).toInt()
        val width = convertDpToPixels(
            context,
            context.resources.getDimension(R.dimen.thumbnail_width)
        ).toInt()
        Glide.with(holder.thumbnailImageView.context)
            .load(article.mediaUrl)
            .override(width, height).placeholder(R.drawable.ic_place_holder)
            .into(holder.thumbnailImageView)
        holder.titleTextView.text = article.title
        holder.authorTextView.text = article.byline
        holder.dateTextView.text = article.publishedDate
        holder.itemView.setOnClickListener {
            viewModel.onArticleClicked(position)
        }
    }

    class ArticleViewHolder(binding: ListItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val thumbnailImageView = binding.thumbnailImageView
        val titleTextView = binding.titleTextView
        val authorTextView = binding.authorTextView
        val dateTextView = binding.dateTextView

    }
}