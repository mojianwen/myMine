package com.mining.safety.repository

import com.mining.safety.api.RetrofitClient
import com.mining.safety.model.Course
import com.mining.safety.model.PageResponse

class CourseRepository {

    private val apiService = RetrofitClient.apiService

    suspend fun getCourseList(page: Int, size: Int): Result<PageResponse<Course>> {
        return try {
            val response = apiService.getCourseList(page, size)
            if (response.isSuccessful && response.body()?.code == 200) {
                response.body()?.data?.let { Result.success(it) }
                    ?: Result.failure(Exception("获取培训课程列表失败"))
            } else {
                Result.failure(Exception(response.body()?.message ?: "获取培训课程列表失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun addCourse(course: Course): Result<Unit> {
        return try {
            val response = apiService.addCourse(course)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "添加培训课程失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateCourse(course: Course): Result<Unit> {
        return try {
            val response = apiService.updateCourse(course)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "更新培训课程失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteCourse(id: Long): Result<Unit> {
        return try {
            val response = apiService.deleteCourse(id)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "删除培训课程失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
