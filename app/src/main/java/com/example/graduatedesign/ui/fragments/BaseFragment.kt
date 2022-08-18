package com.example.graduatedesign.ui.fragments

import androidx.fragment.app.Fragment
import com.example.graduatedesign.adapters.NewsAdapter
import com.example.graduatedesign.ui.NewsViewModel

abstract class BaseFragment(fragmentBreakingNews: Int) : Fragment(fragmentBreakingNews) {

    val TAG: String = javaClass.name
    lateinit var viewModel: NewsViewModel


}