package com.hasanshukurov.breakingnewsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.hasanshukurov.breakingnewsapp.R
import com.hasanshukurov.breakingnewsapp.adapters.NewsAdapter
import com.hasanshukurov.breakingnewsapp.databinding.ActivityMainBinding
import com.hasanshukurov.breakingnewsapp.databinding.FragmentBreakingNewsBinding
import com.hasanshukurov.breakingnewsapp.model.Article
import com.hasanshukurov.breakingnewsapp.ui.viewmodel.NewsViewModel
import com.hasanshukurov.breakingnewsapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreakingNewsFragment : Fragment() {

    private var _binding: FragmentBreakingNewsBinding? = null
    private val binding: FragmentBreakingNewsBinding get() = _binding!!
    private lateinit var newsVewModel: NewsViewModel
    private lateinit var newsAdapter : NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newsVewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBreakingNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        newsVewModel.newsListVM.observe(viewLifecycleOwner){ response ->
            when(response){
                is Resource.Succes -> {
                    binding.paginationProgressBar.visibility = View.INVISIBLE
                    response.data?.let { newsResponse ->
                        val newsList = newsResponse.articles
                        createAdapter(newsList)

                    }
                }
                is Resource.Error -> {
                    binding.paginationProgressBar.visibility = View.INVISIBLE
                    response.message?.let {
                        Log.e("Error: ","xeta bash verdi: $it")
                    }
                }
                is Resource.Loading -> {
                    binding.paginationProgressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun createAdapter(list: List<Article>){
        newsAdapter = NewsAdapter(list)
        binding.rvBreakingNews.adapter = newsAdapter
        binding.rvBreakingNews.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}