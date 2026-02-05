package com.mining.safety.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00150\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ2\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010$\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010%\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002J*\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\'\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lcom/mining/safety/repository/UserRepository;", "", "()V", "apiService", "Lcom/mining/safety/api/ApiService;", "addUser", "Lkotlin/Result;", "", "user", "Lcom/mining/safety/model/User;", "addUser-gIAlu-s", "(Lcom/mining/safety/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUser", "id", "", "deleteUser-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserInfo", "getUserInfo-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserList", "Lcom/mining/safety/model/PageResponse;", "page", "", "size", "getUserList-0E7RQCE", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/mining/safety/model/LoginResponse;", "username", "", "password", "login-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseIntValue", "value", "parseLongValue", "parseStringValue", "updateUser", "updateUser-gIAlu-s", "app_debug"})
public final class UserRepository {
    @org.jetbrains.annotations.NotNull
    private final com.mining.safety.api.ApiService apiService = null;
    
    public UserRepository() {
        super();
    }
    
    private final java.lang.String parseStringValue(java.lang.Object value) {
        return null;
    }
    
    private final long parseLongValue(java.lang.Object value) {
        return 0L;
    }
    
    private final int parseIntValue(java.lang.Object value) {
        return 0;
    }
}