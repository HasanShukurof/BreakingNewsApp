package com.hasanshukurov.breakingnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hasanshukurov.breakingnewsapp.model.Article

@Dao
interface ArticleDao {


    // birincideki LONG yazisini sil gorek ne olur ?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article) : Long

    @Query("SELECT * FROM articlesTable")
    suspend fun  getAllArticles(): List<Article>

    @Delete
    suspend fun deleteArticle(article: Article)

}