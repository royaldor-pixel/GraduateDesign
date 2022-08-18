package com.example.graduatedesign.api

import com.example.graduatedesign.models.NewsData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsAPI {

    @GET("project/list/{page}/json")
    suspend fun getProjectListAsync(
        @Path("page") page: Int = 1,
        @Query("cid") cid: Int = 294
    ): Response<NewsData>


    @GET("article/query/{page}/json")
    suspend fun getSearchListAsync(
        @Path("page") page: Int = 0,
        @Field("k") k: String = ""
    ): Response<NewsData>
}