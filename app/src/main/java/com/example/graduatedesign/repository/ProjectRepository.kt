package com.example.graduatedesign.repository

import com.example.graduatedesign.api.RetrofitInstance
import com.example.graduatedesign.db.ProjectDatabase

class ProjectRepository(
    val db: ProjectDatabase
) {
    suspend fun getProjectList(page: Int, cid: Int) =
        RetrofitInstance.api.getProjectListAsync(page, cid)

    suspend fun searchArticles(page: Int, key: String) =
        RetrofitInstance.api.getSearchListAsync(page, key)
}