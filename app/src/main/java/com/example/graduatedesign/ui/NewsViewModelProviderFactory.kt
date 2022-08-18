package com.example.graduatedesign.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.graduatedesign.repository.ProjectRepository

class NewsViewModelProviderFactory(
    val projectRepository: ProjectRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(projectRepository) as T
    }
}