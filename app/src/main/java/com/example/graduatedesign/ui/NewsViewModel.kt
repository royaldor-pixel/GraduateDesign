package com.example.graduatedesign.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graduatedesign.models.NewsResponse
import com.example.graduatedesign.repository.ProjectRepository
import com.example.graduatedesign.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val projectRepository: ProjectRepository
) : ViewModel() {

    private val _projectList: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val projectList: LiveData<Resource<NewsResponse>> = _projectList


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

    private fun handleProjectListResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}