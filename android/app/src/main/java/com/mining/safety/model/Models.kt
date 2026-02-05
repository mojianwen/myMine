package com.mining.safety.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

// API响应基础类
data class ApiResponse<T>(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: T?
)

// 分页响应
data class PageResponse<T>(
    @SerializedName("records")
    val records: List<T>,
    @SerializedName("total")
    val total: Long,
    @SerializedName("size")
    val size: Int,
    @SerializedName("current")
    val current: Int,
    @SerializedName("pages")
    val pages: Int
)

// 登录请求
data class LoginRequest(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)

// 登录响应
data class LoginResponse(
    @SerializedName("token")
    val token: String,
    @SerializedName("user")
    val user: User
)

// 用户信息
@Parcelize
data class User(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("username")
    var username: String = "",
    @SerializedName("realName")
    var realName: String = "",
    @SerializedName("phone")
    var phone: String = "",
    @SerializedName("email")
    var email: String = "",
    @SerializedName("status")
    var status: Int = 0,
    @SerializedName("createTime")
    var createTime: String = ""
) : Parcelable

// 用户列表请求
data class UserListRequest(
    @SerializedName("current")
    val current: Int = 1,
    @SerializedName("size")
    val size: Int = 10,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("realName")
    val realName: String? = null
)

// 培训素材
@Parcelize
data class Material(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("type")
    var type: String = "",
    @SerializedName("category")
    var category: String = "",
    @SerializedName("duration")
    var duration: String = "",
    @SerializedName("filePath")
    var filePath: String = "",
    @SerializedName("status")
    var status: Int = 0,
    @SerializedName("createTime")
    var createTime: String = ""
) : Parcelable

// 培训课程
@Parcelize
data class Course(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("type")
    var type: String = "",
    @SerializedName("duration")
    var duration: String = "",
    @SerializedName("trainer")
    var trainer: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("status")
    var status: Int = 0,
    @SerializedName("materialIds")
    var materialIds: List<Long> = emptyList(),
    @SerializedName("createTime")
    var createTime: String = ""
) : Parcelable

// 培训试卷
@Parcelize
data class Exam(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("type")
    var type: String = "",
    @SerializedName("totalScore")
    var totalScore: Int = 0,
    @SerializedName("duration")
    var duration: Int = 0,
    @SerializedName("questionCount")
    var questionCount: Int = 0,
    @SerializedName("status")
    var status: Int = 0,
    @SerializedName("createTime")
    var createTime: String = ""
) : Parcelable

// 培训专题
@Parcelize
data class Topic(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("category")
    var category: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("courseCount")
    var courseCount: Int = 0,
    @SerializedName("materialCount")
    var materialCount: Int = 0,
    @SerializedName("status")
    var status: Int = 0,
    @SerializedName("createTime")
    var createTime: String = ""
) : Parcelable

// 线下课堂
@Parcelize
data class Classroom(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("trainer")
    var trainer: String = "",
    @SerializedName("location")
    var location: String = "",
    @SerializedName("startTime")
    var startTime: String = "",
    @SerializedName("endTime")
    var endTime: String = "",
    @SerializedName("maxParticipants")
    var maxParticipants: Int = 0,
    @SerializedName("participantCount")
    var participantCount: Int = 0,
    @SerializedName("status")
    var status: Int = 0,
    @SerializedName("description")
    var description: String = "",
    @SerializedName("materialIds")
    var materialIds: List<Long> = emptyList(),
    @SerializedName("createTime")
    var createTime: String = ""
) : Parcelable
