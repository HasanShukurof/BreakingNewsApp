package com.hasanshukurov.breakingnewsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanshukurov.breakingnewsapp.model.NewsResponse
import com.hasanshukurov.breakingnewsapp.repo.NewsRepository
import com.hasanshukurov.breakingnewsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val repo: NewsRepository): ViewModel() {

    val newsListVM = MutableLiveData<Resource<NewsResponse>>()
    var newsPageVM = 1

    init {
        getNewsVM("us")
    }

    fun getNewsVM(countrycode: String){
        newsListVM.value = Resource.Loading()

        viewModelScope.launch {

            val response = repo.getNewsRepo(countrycode,newsPageVM)
            newsListVM.postValue(handlingBreakingNews(response))
        }
    }

    private fun handlingBreakingNews(response: Response<NewsResponse>): Resource<NewsResponse>{
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Succes(it)
            }
        }
        return Resource.Error("Error: ${response.message()}")
    }





}