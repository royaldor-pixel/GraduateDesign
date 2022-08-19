package com.example.graduatedesign.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.graduatedesign.R
import com.example.graduatedesign.databinding.FragmentArticleBinding
import com.example.graduatedesign.databinding.FragmentBreakingNewsBinding
import com.example.graduatedesign.ui.NewsActivity

class ArticleFragment : BaseFragment() {

    private val args : ArticleFragmentArgs by navArgs()

    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val projectLink = args.projectLink

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(projectLink)

        }
    }
}