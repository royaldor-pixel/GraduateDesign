package com.example.graduatedesign.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.graduatedesign.R
import com.example.graduatedesign.ui.NewsActivity

class ArticleFragment : BaseFragment(R.layout.fragment_article) {

    private val args : ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        Log.d(TAG, args.toString())

        view.findViewById<WebView>(R.id.webView).apply {
            webViewClient = WebViewClient()
        }
    }
}