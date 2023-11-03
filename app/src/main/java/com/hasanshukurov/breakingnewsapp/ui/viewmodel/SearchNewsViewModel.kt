package com.hasanshukurov.breakingnewsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanshukurov.breakingnewsapp.model.NewsResponse
import com.hasanshukurov.breakingnewsapp.repo.NewsRepository
import com.hasanshukurov.breakingnewsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SearchNewsViewModel @Inject constructor(val repo: NewsRepository): ViewModel() {

    val searchNewsListVM = MutableLiveData<Resource<NewsResponse>>()
    var searchNewsPageVM = 1


    fun searchNewsVM(searchText: String){

        searchNewsListVM.value = Resource.Loading()

        viewModelScope.launch {
            val response = repo.searchNewsRepo(searchText,searchNewsPageVM)
            searchNewsListVM.postValue(handleSearchNewsResponse(response))
        }
    }

    private fun handleSearchNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Succes(it)
            }
        }
        return Resource.Error("Error: ${response.message()}",null)
    }

}