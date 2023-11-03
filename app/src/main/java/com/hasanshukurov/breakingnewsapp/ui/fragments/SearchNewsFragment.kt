package com.hasanshukurov.breakingnewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasanshukurov.breakingnewsapp.adapters.NewsAdapter
import com.hasanshukurov.breakingnewsapp.databinding.FragmentSearchNewsBinding
import com.hasanshukurov.breakingnewsapp.model.Article
import com.hasanshukurov.breakingnewsapp.ui.viewmodel.SearchNewsViewModel
import com.hasanshukurov.breakingnewsapp.util.Constants.Companion.SEARCH_NEWS_TIME_DELAY
import com.hasanshukurov.breakingnewsapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class SearchNewsFragment : Fragment() {

    private var _binding: FragmentSearchNewsBinding? = null
    private val binding: FragmentSearchNewsBinding get() = _binding!!
    private lateinit var newsVewModel: SearchNewsViewModel
    private lateinit var newsAdapter : NewsAdapter
    var job : Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val x : SearchNewsViewModel by viewModels()
        newsVewModel = x

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        makeSearching()

        newsVewModel.searchNewsListVM.observe(viewLifecycleOwner){ resourceResponse->
            when(resourceResponse){
                is Resource.Succes -> {
                    binding.paginationProgressBar.visibility = View.INVISIBLE
                    resourceResponse.data?.let { newsResponse ->
                        val newsList = newsResponse.articles
                        createRv(newsList)
                    }
                }
                is Resource.Error -> {
                    binding.paginationProgressBar.visibility = View.INVISIBLE
                    Resource.Error("Error: ${resourceResponse.message}",null)
                }
                is Resource.Loading -> {
                    binding.paginationProgressBar.visibility = View.VISIBLE
                }
            }
        }


    }

    private fun createRv(list: List<Article>){
        newsAdapter = NewsAdapter(list)
        binding.rvSearchNews.adapter = newsAdapter
        binding.rvSearchNews.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun makeSearching(){

        binding.etSearch.addTextChangedListener { editable ->

            job?.cancel()

            job = MainScope().launch {
                delay(SEARCH_NEWS_TIME_DELAY)
                editable?.let {
                    if (it.toString().isNotEmpty()){
                        newsVewModel.searchNewsVM(it.toString())
                    }
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        job?.cancel()
    }
}































