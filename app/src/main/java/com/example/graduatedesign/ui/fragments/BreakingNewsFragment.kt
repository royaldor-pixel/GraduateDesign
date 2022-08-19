package com.example.graduatedesign.ui.fragments;

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.graduatedesign.R
import com.example.graduatedesign.adapters.NewsAdapter
import com.example.graduatedesign.databinding.FragmentBreakingNewsBinding
import com.example.graduatedesign.util.Resource

class BreakingNewsFragment : BaseFragment() {

    lateinit var newsAdapter: NewsAdapter

    private var _binding: FragmentBreakingNewsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBreakingNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        showProgressBar()

        newsAdapter.setOnItemClickListener { project ->
            project.link.let {
                findNavController()
                    .navigate(
                        BreakingNewsFragmentDirections
                            .actionBreakingNewsFragmentToArticleFragment(it)
                    )
            }
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
        binding.paginationProgressBarBN.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.paginationProgressBarBN.visibility = View.INVISIBLE
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        requireView().findViewById<RecyclerView>(R.id.rvBreakingNews).apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}
