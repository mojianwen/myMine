package com.mining.safety.viewmodel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u000e\u0010\u0017\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/mining/safety/viewmodel/ClassroomViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_classroomList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/mining/safety/model/Classroom;", "_error", "", "_loading", "", "classroomList", "Lkotlinx/coroutines/flow/StateFlow;", "getClassroomList", "()Lkotlinx/coroutines/flow/StateFlow;", "classroomRepository", "Lcom/mining/safety/repository/ClassroomRepository;", "currentPage", "", "error", "getError", "loading", "getLoading", "pageSize", "addClassroom", "", "classroom", "deleteClassroom", "id", "", "loadClassroomList", "signClassroom", "updateClassroom", "app_debug"})
public final class ClassroomViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.mining.safety.repository.ClassroomRepository classroomRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.mining.safety.model.Classroom>> _classroomList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.mining.safety.model.Classroom>> classroomList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _loading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> loading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    private int currentPage = 1;
    private final int pageSize = 10;
    
    public ClassroomViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.mining.safety.model.Classroom>> getClassroomList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    public final void loadClassroomList() {
    }
    
    public final void addClassroom(@org.jetbrains.annotations.NotNull
    com.mining.safety.model.Classroom classroom) {
    }
    
    public final void updateClassroom(@org.jetbrains.annotations.NotNull
    com.mining.safety.model.Classroom classroom) {
    }
    
    public final void deleteClassroom(long id) {
    }
    
    public final void signClassroom(long id) {
    }
}