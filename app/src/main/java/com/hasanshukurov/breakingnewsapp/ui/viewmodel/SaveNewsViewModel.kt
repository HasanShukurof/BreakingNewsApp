package com.hasanshukurov.breakingnewsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanshukurov.breakingnewsapp.model.Article
import com.hasanshukurov.breakingnewsapp.repo.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


//@HiltViewModel
//class SaveNewsViewModel @Inject constructor(val repo: NewsRepository): ViewModel() {
/*
    val newsList = MutableLiveData<List<Article>>()

    fun savedNews(article: Article) {
        viewModelScope.launch {
            repo.upsertArticle(article)
        }
    }

    fun deleteNews(article: Article) {
        viewModelScope.launch {
            repo.deleteArticle(article)
        }
    }

    fun getAllSavedNews() {
        viewModelScope.launch {
            newsList.value = repo.getSavedNews()
        }
    }

 */

