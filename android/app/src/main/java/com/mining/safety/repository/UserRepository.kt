package com.mining.safety.repository

import com.mining.safety.api.RetrofitClient
import com.mining.safety.model.*

class UserRepository {

    private val apiService = RetrofitClient.apiService

    suspend fun login(username: String, password: String): Result<LoginResponse> {
        return try {
            val response = apiService.login(LoginRequest(username, password))
            if (response.isSuccessful && response.body()?.code == 200) {
                val data = response.body()?.data
                if (data != null && data is Map<*, *>) {
                    val token = data["token"] as? String ?: ""
                    val userMap = data["user"] as? Map<*, *>
                    val user = if (userMap != null) {
                        User(
                            id = (userMap["id"] as? Number)?.toLong() ?: 0,
                            username = userMap["username"] as? String ?: "",
                            realName = userMap["realName"] as? String ?: "",
                            phone = userMap["phone"] as? String ?: "",
                            email = userMap["email"] as? String ?: "",
                            status = (userMap["status"] as? Number)?.toInt() ?: 0,
                            createTime = userMap["createTime"] as? String ?: ""
                        )
                    } else {
                        User()
                    }
                    Result.success(LoginResponse(token, user))
                } else {
                    Result.failure(Exception("登录失败：数据格式错误"))
                }
            } else {
                Result.failure(Exception(response.body()?.message ?: "登录失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUserInfo(): Result<User> {
        return try {
            val response = apiService.getUserInfo()
            if (response.isSuccessful && response.body()?.code == 200) {
                response.body()?.data?.let { Result.success(it) }
                    ?: Result.failure(Exception("获取用户信息失败"))
            } else {
                Result.failure(Exception(response.body()?.message ?: "获取用户信息失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUserList(page: Int, size: Int): Result<PageResponse<User>> {
        return try {
            val response = apiService.getUserList(UserListRequest(page, size))
            if (response.isSuccessful && response.body()?.code == 200) {
                response.body()?.data?.let { Result.success(it) }
                    ?: Result.failure(Exception("获取用户列表失败"))
            } else {
                Result.failure(Exception(response.body()?.message ?: "获取用户列表失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun addUser(user: User): Result<Unit> {
        return try {
            val response = apiService.addUser(user)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "添加用户失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateUser(user: User): Result<Unit> {
        return try {
            val response = apiService.updateUser(user)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "更新用户失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteUser(id: Long): Result<Unit> {
        return try {
            val response = apiService.deleteUser(id)
            if (response.isSuccessful && response.body()?.code == 200) {
                Result.success(Unit)
            } else {
                Result.failure(Exception(response.body()?.message ?: "删除用户失败"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
