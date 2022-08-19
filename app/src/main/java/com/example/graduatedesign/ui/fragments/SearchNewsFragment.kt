package com.example.graduatedesign.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduatedesign.adapters.NewsAdapter
import com.example.graduatedesign.databinding.FragmentSearchNewsBinding
import com.example.graduatedesign.util.Resource
import kotlinx.coroutines.Job


class SearchNewsFragment : BaseFragment() {


    private var _binding: FragmentSearchNewsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchNewsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()


        var job: Job? = null


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
        binding.paginationProgressBarSN.visibility = View.INVISIBLE
    }


    private fun showProgressBar() {
        binding.paginationProgressBarSN.visibility = View.INVISIBLE
    }


    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvSearchNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}