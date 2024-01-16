package com.hasanshukurov.breakingnewsapp.repo

import com.hasanshukurov.breakingnewsapp.api.NewsApi
import com.hasanshukurov.breakingnewsapp.db.ArticleDao
import com.hasanshukurov.breakingnewsapp.db.ArticleDatabase
import com.hasanshukurov.breakingnewsapp.model.Article
import com.hasanshukurov.breakingnewsapp.model.NewsResponse
import com.hasanshukurov.breakingnewsapp.util.Resource
import retrofit2.Response
import java.lang.reflect.Constructor
import javax.inject.Inject

class NewsRepository @Inject constructor( val api: NewsApi) {


    suspend fun getNewsRepo(countryCode: String,page: Int) =
        api.getBreakingNews(countryCode, page)

    suspend fun searchNewsRepo(searchQuery: String, pageNumber: Int) =
        api.searchForNews(searchQuery,pageNumber)


//    suspend fun upsertArticle(article: Article) = db.upsert(article)


 //   suspend fun getSavedNews() = db.getAllArticles()


 //   suspend fun deleteArticle(article: Article) = db.deleteArticle(article)

}