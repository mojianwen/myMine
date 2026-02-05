package com.mining.safety.repository

import com.mining.safety.api.RetrofitClient
import com.mining.safety.model.Material
import com.mining.safety.model.PageResponse

class MaterialRepository {

    private val apiService = RetrofitClient.apiService

    suspend fun getMaterialList(page: Int, size: Int): Result<PageResponse<Material>> {
        return try {
            val response = apiService.getMaterialList(page, size)
            if (response.isSuccessful && response.body()?.code == 200) {
                response.body()?.data?.let { Result.success(it) }
                    ?: Result.failure(Exception("获取培训素材列表失败"))
            } else {
                Result.failure(Exception(response.body()?.message ?: "获取培训素材列表失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun addMaterial(material: Material): Result<Unit> {
        return try {
            val response = apiService.addMaterial(material)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "添加培训素材失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateMaterial(material: Material): Result<Unit> {
        return try {
            val response = apiService.updateMaterial(material)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "更新培训素材失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteMaterial(id: Long): Result<Unit> {
        return try {
            val response = apiService.deleteMaterial(id)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "删除培训素材失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
