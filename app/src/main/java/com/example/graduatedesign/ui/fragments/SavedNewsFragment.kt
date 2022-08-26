package com.example.graduatedesign.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.graduatedesign.R
import com.example.graduatedesign.adapters.NewsAdapter
import com.example.graduatedesign.databinding.FragmentBreakingNewsBinding
import com.example.graduatedesign.databinding.FragmentSavedNewsBinding
import com.example.graduatedesign.ui.NewsActivity
import com.example.graduatedesign.ui.NewsViewModel

class SavedNewsFragment:BaseFragment() {

    lateinit var newsAdapter: NewsAdapter

    private var _binding: FragmentSavedNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSavedNewsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = (activity as NewsActivity).viewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}