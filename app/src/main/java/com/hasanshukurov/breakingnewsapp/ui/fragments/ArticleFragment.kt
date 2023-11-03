package com.hasanshukurov.breakingnewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.hasanshukurov.breakingnewsapp.R
import com.hasanshukurov.breakingnewsapp.databinding.FragmentArticleBinding
import com.hasanshukurov.breakingnewsapp.databinding.FragmentBreakingNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleFragment : Fragment() {

    private var _binding: FragmentArticleBinding? = null
    private val binding: FragmentArticleBinding get() = _binding!!
    val args: ArticleFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val argsItem = args.articleArg
        binding.webView.apply {
            webViewClient = WebViewClient()

            argsItem.url?.let {
                loadUrl(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}