package com.mining.safety.repository

import com.mining.safety.api.RetrofitClient
import com.mining.safety.model.Classroom
import com.mining.safety.model.PageResponse

class ClassroomRepository {

    private val apiService = RetrofitClient.apiService

    suspend fun getClassroomList(page: Int, size: Int): Result<PageResponse<Classroom>> {
        return try {
            val response = apiService.getClassroomList(page, size)
            if (response.isSuccessful && response.body()?.code == 200) {
                response.body()?.data?.let { Result.success(it) }
                    ?: Result.failure(Exception("获取线下课堂列表失败"))
            } else {
                Result.failure(Exception(response.body()?.message ?: "获取线下课堂列表失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun addClassroom(classroom: Classroom): Result<Unit> {
        return try {
            val response = apiService.addClassroom(classroom)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "添加线下课堂失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateClassroom(classroom: Classroom): Result<Unit> {
        return try {
            val response = apiService.updateClassroom(classroom)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "更新线下课堂失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteClassroom(id: Long): Result<Unit> {
        return try {
            val response = apiService.deleteClassroom(id)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "删除线下课堂失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun signClassroom(id: Long): Result<Unit> {
        return try {
            val response = apiService.signClassroom(id)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "签到失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
