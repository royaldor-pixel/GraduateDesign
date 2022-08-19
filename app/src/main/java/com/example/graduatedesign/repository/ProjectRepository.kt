package com.example.graduatedesign.repository

import com.example.graduatedesign.api.RetrofitInstance
import com.example.graduatedesign.db.ProjectDatabase

class ProjectRepository(
    val db: ProjectDatabase
) {
    suspend fun getProjectList(page: Int, cid: Int) =
        RetrofitInstance.api.getProjectListAsync(page, cid)

    suspend fun searchArticles(key: String) =
        RetrofitInstance.api.getSearchListAsync(key)
}