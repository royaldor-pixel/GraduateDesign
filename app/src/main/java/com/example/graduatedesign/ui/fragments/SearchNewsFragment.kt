package com.example.graduatedesign.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.graduatedesign.R
import com.example.graduatedesign.ui.NewsActivity
import com.example.graduatedesign.ui.NewsViewModel

class SearchNewsFragment:Fragment(R.layout.fragment_search_news) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}