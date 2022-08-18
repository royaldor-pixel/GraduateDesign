package com.example.graduatedesign.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.graduatedesign.Project

@Dao
interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(project: Project): Long

    @Query("SELECT * FROM projects")
    fun getAllProjects(): LiveData<List<Project>>

    @Delete
    suspend fun deleteProject(project: Project)
}