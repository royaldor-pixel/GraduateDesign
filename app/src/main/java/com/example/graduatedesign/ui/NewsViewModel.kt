package com.example.graduatedesign.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graduatedesign.models.NewsData
import com.example.graduatedesign.repository.ProjectRepository
import com.example.graduatedesign.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val projectRepository: ProjectRepository
) : ViewModel() {

    private val _projectList: MutableLiveData<Resource<NewsData>> = MutableLiveData()
    val projectList: LiveData<Resource<NewsData>> = _projectList

    private val _searchList: MutableLiveData<Resource<NewsData>> = MutableLiveData()
    val searchList: LiveData<Resource<NewsData>> = _projectList

    var searchPage = 0
    var searchKey = ""

    var projectListPage = 1
    var projectCid = 294


    init {
        getProjectList(projectListPage, projectCid)
    }

    fun getProjectList(page: Int, cid: Int) = viewModelScope.launch {
        _projectList.postValue(Resource.Loading())
        val response = projectRepository.getProjectList(page, cid)
        _projectList.postValue(handleProjectListResponse(response))
    }

    fun searchArticle(page: Int, key: String) = viewModelScope.launch {
        _searchList.postValue(Resource.Loading())
        val response = projectRepository.searchArticles(page, key)
        _searchList.postValue(handleSearchResponse(response))
    }

    private fun handleProjectListResponse(response: Response<NewsData>): Resource<NewsData> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleSearchResponse(response: Response<NewsData>): Resource<NewsData> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}