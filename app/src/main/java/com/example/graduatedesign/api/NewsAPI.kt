package com.example.graduatedesign.api

import com.example.graduatedesign.NewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsAPI {

    @GET("project/list/{page}/json")
    fun getProjectListAsync(
        @Path("page") page: Int = 1,
        @Query("cid") cid: Int = 294
    ): Deferred<NewsResponse>


    @GET("article/query/{page}/json")
    fun getSearchListAsync(
        @Path("page") page: Int = 0,
        @Field("k") k: String = ""
    ): Deferred<NewsResponse>
}