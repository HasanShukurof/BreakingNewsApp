package com.hasanshukurov.breakingnewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hasanshukurov.breakingnewsapp.R
import com.hasanshukurov.breakingnewsapp.databinding.FragmentSavedNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedNewsFragment : Fragment() {

    private var _binding: FragmentSavedNewsBinding? = null
    private val binding: FragmentSavedNewsBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}