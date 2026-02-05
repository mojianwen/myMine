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
                if (data != null) {
                    // 验证数据确实是期望的Map格式
                    if (data !is Map<*, *>) {
                        return Result.failure(Exception("登录失败：数据格式错误"))
                    }
                    
                    val token = parseStringValue(data["token"])
                    val userMap = data["user"] as? Map<*, *>?
                    
                    if (userMap != null) {
                        val user = User(
                            id = parseLongValue(userMap["id"]),
                            username = parseStringValue(userMap["username"]),
                            realName = parseStringValue(userMap["realName"]),
                            phone = parseStringValue(userMap["phone"]),
                            email = parseStringValue(userMap["email"]),
                            status = parseIntValue(userMap["status"]),
                            createTime = parseStringValue(userMap["createTime"])
                        )
                        Result.success(LoginResponse(token, user))
                    } else {
                        Result.failure(Exception("登录失败：用户数据缺失"))
                    }
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
    
    private fun parseStringValue(value: Any?): String {
        return when (value) {
            is String -> value
            is Number -> value.toString()
            else -> ""
        }
    }
    
    private fun parseLongValue(value: Any?): Long {
        return when (value) {
            is Number -> value.toLong()
            is String -> value.toLongOrNull() ?: 0
            else -> 0
        }
    }
    
    private fun parseIntValue(value: Any?): Int {
        return when (value) {
            is Number -> value.toInt()
            is String -> value.toIntOrNull() ?: 0
            else -> 0
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