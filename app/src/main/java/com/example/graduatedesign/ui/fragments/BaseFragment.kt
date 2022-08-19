package com.example.graduatedesign.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.graduatedesign.adapters.NewsAdapter
import com.example.graduatedesign.ui.NewsActivity
import com.example.graduatedesign.ui.NewsViewModel

abstract class BaseFragment() : Fragment() {

    val TAG: String by lazy { javaClass.name }

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }

}