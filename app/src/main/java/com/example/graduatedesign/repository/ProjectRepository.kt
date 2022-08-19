package com.example.graduatedesign.repository

import com.example.graduatedesign.api.RetrofitInstance
import com.example.graduatedesign.db.ProjectDatabase
import com.example.graduatedesign.models.NewsData
import retrofit2.Call

class ProjectRepository(
    val db: ProjectDatabase
) {
    suspend fun getProjectList(page: Int, cid: Int) =
         RetrofitInstance.api.getProjectListAsync(page, cid)
}