package com.mining.safety.repository

import com.mining.safety.api.RetrofitClient
import com.mining.safety.model.Exam
import com.mining.safety.model.PageResponse

class ExamRepository {

    private val apiService = RetrofitClient.apiService

    suspend fun getExamList(page: Int, size: Int): Result<PageResponse<Exam>> {
        return try {
            val response = apiService.getExamList(page, size)
            if (response.isSuccessful && response.body()?.code == 200) {
                response.body()?.data?.let { Result.success(it) }
                    ?: Result.failure(Exception("获取培训试卷列表失败"))
            } else {
                Result.failure(Exception(response.body()?.message ?: "获取培训试卷列表失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun addExam(exam: Exam): Result<Unit> {
        return try {
            val response = apiService.addExam(exam)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "添加培训试卷失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateExam(exam: Exam): Result<Unit> {
        return try {
            val response = apiService.updateExam(exam)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "更新培训试卷失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteExam(id: Long): Result<Unit> {
        return try {
            val response = apiService.deleteExam(id)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "删除培训试卷失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
