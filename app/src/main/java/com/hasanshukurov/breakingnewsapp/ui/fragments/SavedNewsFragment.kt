package com.hasanshukurov.breakingnewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.hasanshukurov.breakingnewsapp.adapters.NewsAdapter
import com.hasanshukurov.breakingnewsapp.databinding.FragmentSavedNewsBinding
import com.hasanshukurov.breakingnewsapp.model.Article
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedNewsFragment : Fragment() {

    private var _binding: FragmentSavedNewsBinding? = null
    private val binding: FragmentSavedNewsBinding get() = _binding!!
   // private lateinit var viewModel: SaveNewsViewModel
   // private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // viewModel = ViewModelProvider(this).get(SaveNewsViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSavedNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
        viewModel.newsList.observe(viewLifecycleOwner) {
            makeAdapter(it)
        }

        viewModel.getAllSavedNews()

 */
    }
/*
    private fun makeAdapter(newsList: List<Article>){
        adapter = NewsAdapter(newsList)
        binding.rvSavedNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSavedNews.adapter = adapter
    }

 */

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}