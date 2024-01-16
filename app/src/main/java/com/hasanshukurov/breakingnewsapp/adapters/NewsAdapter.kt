package com.hasanshukurov.breakingnewsapp.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.hasanshukurov.breakingnewsapp.R
import com.hasanshukurov.breakingnewsapp.databinding.ItemArticlePreviewBinding
import com.hasanshukurov.breakingnewsapp.model.Article

class NewsAdapter(var newsList: List<Article>): RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    class NewsHolder(val binding: ItemArticlePreviewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val binding = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val article = newsList[position]

            holder.itemView.apply {
                val circularProgressDrawable = CircularProgressDrawable(holder.itemView.context)
                circularProgressDrawable.strokeWidth = 5f
                circularProgressDrawable.centerRadius = 30f
                circularProgressDrawable.start()

                Glide.with(holder.itemView.context)
                    .load(article.urlToImage)
                    .placeholder(circularProgressDrawable)
                    .into(holder.binding.ivArticleImage)

         //             Picasso.get().load(article.urlToImage).into(holder.binding.ivArticleImage)
                holder.binding.tvSource.text = article.source.name
                holder.binding.tvTitle.text = article.title
                holder.binding.tvDescription.text = article.description
                holder.binding.tvPublishedAt.text = article.publishedAt
                setOnClickListener {
                    val bundle = Bundle().apply {
                        putSerializable("articleArg",article)
                    }
                    findNavController().navigate(R.id.action_breakingNewsFragment_to_articleFragment,bundle)
                }
            }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}