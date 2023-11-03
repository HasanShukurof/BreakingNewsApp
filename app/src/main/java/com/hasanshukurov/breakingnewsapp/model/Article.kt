package com.hasanshukurov.breakingnewsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "articlesTable")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String? = null,
    val source: Source,
    val title: String,
    val url: String? = null,
    val urlToImage: String
) : Serializable