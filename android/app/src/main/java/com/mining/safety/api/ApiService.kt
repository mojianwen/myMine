package com.mining.safety.api

import com.mining.safety.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    // 用户相关接口
    @POST("/api/user/login")
    suspend fun login(@Body request: LoginRequest): Response<ApiResponse<Map<String, Any>>>

    @GET("/api/user/info")
    suspend fun getUserInfo(): Response<ApiResponse<User>>

    @POST("/api/user/list")
    suspend fun getUserList(@Body request: UserListRequest): Response<ApiResponse<PageResponse<User>>>

    @POST("/api/user/add")
    suspend fun addUser(@Body user: User): Response<ApiResponse<Unit>>

    @POST("/api/user/update")
    suspend fun updateUser(@Body user: User): Response<ApiResponse<Unit>>

    @DELETE("/api/user/delete/{id}")
    suspend fun deleteUser(@Path("id") id: Long): Response<ApiResponse<Unit>>

    // 培训素材相关接口
    @GET("/api/training/material/list")
    suspend fun getMaterialList(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<ApiResponse<PageResponse<Material>>>

    @POST("/api/training/material")
    suspend fun addMaterial(@Body material: Material): Response<ApiResponse<Unit>>

    @PUT("/api/training/material")
    suspend fun updateMaterial(@Body material: Material): Response<ApiResponse<Unit>>

    @DELETE("/api/training/material/{id}")
    suspend fun deleteMaterial(@Path("id") id: Long): Response<ApiResponse<Unit>>

    // 培训课程相关接口
    @GET("/api/training/course/list")
    suspend fun getCourseList(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<ApiResponse<PageResponse<Course>>>

    @POST("/api/training/course")
    suspend fun addCourse(@Body course: Course): Response<ApiResponse<Unit>>

    @PUT("/api/training/course")
    suspend fun updateCourse(@Body course: Course): Response<ApiResponse<Unit>>

    @DELETE("/api/training/course/{id}")
    suspend fun deleteCourse(@Path("id") id: Long): Response<ApiResponse<Unit>>

    // 培训试卷相关接口
    @GET("/api/training/exam/list")
    suspend fun getExamList(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<ApiResponse<PageResponse<Exam>>>

    @POST("/api/training/exam")
    suspend fun addExam(@Body exam: Exam): Response<ApiResponse<Unit>>

    @PUT("/api/training/exam")
    suspend fun updateExam(@Body exam: Exam): Response<ApiResponse<Unit>>

    @DELETE("/api/training/exam/{id}")
    suspend fun deleteExam(@Path("id") id: Long): Response<ApiResponse<Unit>>

    // 培训专题相关接口
    @GET("/api/training/topic/list")
    suspend fun getTopicList(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<ApiResponse<PageResponse<Topic>>>

    @POST("/api/training/topic")
    suspend fun addTopic(@Body topic: Topic): Response<ApiResponse<Unit>>

    @PUT("/api/training/topic")
    suspend fun updateTopic(@Body topic: Topic): Response<ApiResponse<Unit>>

    @DELETE("/api/training/topic/{id}")
    suspend fun deleteTopic(@Path("id") id: Long): Response<ApiResponse<Unit>>

    // 线下课堂相关接口
    @GET("/api/classroom/list")
    suspend fun getClassroomList(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<ApiResponse<PageResponse<Classroom>>>

    @POST("/api/classroom/add")
    suspend fun addClassroom(@Body classroom: Classroom): Response<ApiResponse<Unit>>

    @PUT("/api/classroom/update")
    suspend fun updateClassroom(@Body classroom: Classroom): Response<ApiResponse<Unit>>

    @DELETE("/api/classroom/delete/{id}")
    suspend fun deleteClassroom(@Path("id") id: Long): Response<ApiResponse<Unit>>

    @POST("/api/classroom/sign/{id}")
    suspend fun signClassroom(@Path("id") id: Long): Response<ApiResponse<Unit>>
}
