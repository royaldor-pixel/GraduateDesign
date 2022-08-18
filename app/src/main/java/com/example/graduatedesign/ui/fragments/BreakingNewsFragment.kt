package com.example.graduatedesign.ui.fragments;

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.graduatedesign.R
import com.example.graduatedesign.adapters.NewsAdapter
import com.example.graduatedesign.ui.NewsActivity
import com.example.graduatedesign.util.Resource

class BreakingNewsFragment : BaseFragment(R.layout.fragment_breaking_news) {

    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putString("project",it.projectLink)
            }
            findNavController().navigate(
                R.id.action_breakingNewsFragment_to_articleFragment,
                bundle
            )
        }

        viewModel.projectList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        newsAdapter.differ.submitList(it.data.datas)
                        Log.d(TAG, "Success")
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occurred: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        }
    }

    private fun hideProgressBar() {
        view?.findViewById<ProgressBar>(R.id.paginationProgressBar)?.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        view?.findViewById<ProgressBar>(R.id.paginationProgressBar)?.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        view?.findViewById<RecyclerView>(R.id.rvBreakingNews)?.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}
