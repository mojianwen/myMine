package com.mining.safety.api;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\'\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\'\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\'\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\'\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\'\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\'\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\'\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\'\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\'\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\'\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J7\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\'0\u00040\u00032\b\b\u0001\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020)H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J7\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\'0\u00040\u00032\b\b\u0001\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020)H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J7\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\'0\u00040\u00032\b\b\u0001\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020)H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J7\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\'0\u00040\u00032\b\b\u0001\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020)H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J7\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\'0\u00040\u00032\b\b\u0001\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020)H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J\u001d\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J-\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\'0\u00040\u00032\b\b\u0001\u00103\u001a\u000204H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00105J3\u00106\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u0001070\u00040\u00032\b\b\u0001\u00103\u001a\u000209H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\'\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\'\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\'\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\'\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\'\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\'\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\'\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006B"}, d2 = {"Lcom/mining/safety/api/ApiService;", "", "addClassroom", "Lretrofit2/Response;", "Lcom/mining/safety/model/ApiResponse;", "", "classroom", "Lcom/mining/safety/model/Classroom;", "(Lcom/mining/safety/model/Classroom;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCourse", "course", "Lcom/mining/safety/model/Course;", "(Lcom/mining/safety/model/Course;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addExam", "exam", "Lcom/mining/safety/model/Exam;", "(Lcom/mining/safety/model/Exam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMaterial", "material", "Lcom/mining/safety/model/Material;", "(Lcom/mining/safety/model/Material;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTopic", "topic", "Lcom/mining/safety/model/Topic;", "(Lcom/mining/safety/model/Topic;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addUser", "user", "Lcom/mining/safety/model/User;", "(Lcom/mining/safety/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteClassroom", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCourse", "deleteExam", "deleteMaterial", "deleteTopic", "deleteUser", "getClassroomList", "Lcom/mining/safety/model/PageResponse;", "page", "", "size", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCourseList", "getExamList", "getMaterialList", "getTopicList", "getUserInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserList", "request", "Lcom/mining/safety/model/UserListRequest;", "(Lcom/mining/safety/model/UserListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "", "", "Lcom/mining/safety/model/LoginRequest;", "(Lcom/mining/safety/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signClassroom", "updateClassroom", "updateCourse", "updateExam", "updateMaterial", "updateTopic", "updateUser", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "/api/user/login")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object login(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.LoginRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<java.util.Map<java.lang.String, java.lang.Object>>>> $completion);
    
    @retrofit2.http.GET(value = "/api/user/info")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserInfo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<com.mining.safety.model.User>>> $completion);
    
    @retrofit2.http.POST(value = "/api/user/list")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserList(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.UserListRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<com.mining.safety.model.PageResponse<com.mining.safety.model.User>>>> $completion);
    
    @retrofit2.http.POST(value = "/api/user/add")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addUser(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.POST(value = "/api/user/update")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUser(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.DELETE(value = "/api/user/delete/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteUser(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.GET(value = "/api/training/material/list")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMaterialList(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<com.mining.safety.model.PageResponse<com.mining.safety.model.Material>>>> $completion);
    
    @retrofit2.http.POST(value = "/api/training/material")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addMaterial(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.Material material, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.PUT(value = "/api/training/material")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateMaterial(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.Material material, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.DELETE(value = "/api/training/material/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteMaterial(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.GET(value = "/api/training/course/list")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCourseList(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<com.mining.safety.model.PageResponse<com.mining.safety.model.Course>>>> $completion);
    
    @retrofit2.http.POST(value = "/api/training/course")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addCourse(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.Course course, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.PUT(value = "/api/training/course")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateCourse(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.Course course, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.DELETE(value = "/api/training/course/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteCourse(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.GET(value = "/api/training/exam/list")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getExamList(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<com.mining.safety.model.PageResponse<com.mining.safety.model.Exam>>>> $completion);
    
    @retrofit2.http.POST(value = "/api/training/exam")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addExam(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.Exam exam, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.PUT(value = "/api/training/exam")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateExam(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.Exam exam, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.DELETE(value = "/api/training/exam/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteExam(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.GET(value = "/api/training/topic/list")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTopicList(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<com.mining.safety.model.PageResponse<com.mining.safety.model.Topic>>>> $completion);
    
    @retrofit2.http.POST(value = "/api/training/topic")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addTopic(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.Topic topic, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.PUT(value = "/api/training/topic")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateTopic(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.Topic topic, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.DELETE(value = "/api/training/topic/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTopic(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.GET(value = "/api/classroom/list")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getClassroomList(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<com.mining.safety.model.PageResponse<com.mining.safety.model.Classroom>>>> $completion);
    
    @retrofit2.http.POST(value = "/api/classroom/add")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addClassroom(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.Classroom classroom, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.PUT(value = "/api/classroom/update")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateClassroom(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.mining.safety.model.Classroom classroom, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.DELETE(value = "/api/classroom/delete/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteClassroom(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
    
    @retrofit2.http.POST(value = "/api/classroom/sign/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object signClassroom(@retrofit2.http.Path(value = "id")
    long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.mining.safety.model.ApiResponse<kotlin.Unit>>> $completion);
}