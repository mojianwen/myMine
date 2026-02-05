package com.mining.safety.repository

import com.mining.safety.api.RetrofitClient
import com.mining.safety.model.PageResponse
import com.mining.safety.model.Topic

class TopicRepository {

    private val apiService = RetrofitClient.apiService

    suspend fun getTopicList(page: Int, size: Int): Result<PageResponse<Topic>> {
        return try {
            val response = apiService.getTopicList(page, size)
            if (response.isSuccessful && response.body()?.code == 200) {
                response.body()?.data?.let { Result.success(it) }
                    ?: Result.failure(Exception("获取培训专题列表失败"))
            } else {
                Result.failure(Exception(response.body()?.message ?: "获取培训专题列表失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun addTopic(topic: Topic): Result<Unit> {
        return try {
            val response = apiService.addTopic(topic)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "添加培训专题失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateTopic(topic: Topic): Result<Unit> {
        return try {
            val response = apiService.updateTopic(topic)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "更新培训专题失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteTopic(id: Long): Result<Unit> {
        return try {
            val response = apiService.deleteTopic(id)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "删除培训专题失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
