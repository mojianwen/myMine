package com.mining.safety.viewmodel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/mining/safety/viewmodel/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_loginState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mining/safety/viewmodel/LoginViewModel$LoginState;", "_password", "", "_username", "loginState", "Lkotlinx/coroutines/flow/StateFlow;", "getLoginState", "()Lkotlinx/coroutines/flow/StateFlow;", "password", "getPassword", "userRepository", "Lcom/mining/safety/repository/UserRepository;", "username", "getUsername", "login", "", "onPasswordChange", "value", "onUsernameChange", "LoginState", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.mining.safety.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.mining.safety.viewmodel.LoginViewModel.LoginState> _loginState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.mining.safety.viewmodel.LoginViewModel.LoginState> loginState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _username = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> username = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _password = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> password = null;
    
    public LoginViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.mining.safety.viewmodel.LoginViewModel.LoginState> getLoginState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getPassword() {
        return null;
    }
    
    public final void onUsernameChange(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final void onPasswordChange(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final void login() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/mining/safety/viewmodel/LoginViewModel$LoginState;", "", "()V", "Error", "Idle", "Loading", "Success", "Lcom/mining/safety/viewmodel/LoginViewModel$LoginState$Error;", "Lcom/mining/safety/viewmodel/LoginViewModel$LoginState$Idle;", "Lcom/mining/safety/viewmodel/LoginViewModel$LoginState$Loading;", "Lcom/mining/safety/viewmodel/LoginViewModel$LoginState$Success;", "app_debug"})
    public static abstract class LoginState {
        
        private LoginState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/mining/safety/viewmodel/LoginViewModel$LoginState$Error;", "Lcom/mining/safety/viewmodel/LoginViewModel$LoginState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.mining.safety.viewmodel.LoginViewModel.LoginState {
            @org.jetbrains.annotations.NotNull
            private final java.lang.String message = null;
            
            public Error(@org.jetbrains.annotations.NotNull
            java.lang.String message) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.mining.safety.viewmodel.LoginViewModel.LoginState.Error copy(@org.jetbrains.annotations.NotNull
            java.lang.String message) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override
            @org.jetbrains.annotations.NotNull
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/mining/safety/viewmodel/LoginViewModel$LoginState$Idle;", "Lcom/mining/safety/viewmodel/LoginViewModel$LoginState;", "()V", "app_debug"})
        public static final class Idle extends com.mining.safety.viewmodel.LoginViewModel.LoginState {
            @org.jetbrains.annotations.NotNull
            public static final com.mining.safety.viewmodel.LoginViewModel.LoginState.Idle INSTANCE = null;
            
            private Idle() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/mining/safety/viewmodel/LoginViewModel$LoginState$Loading;", "Lcom/mining/safety/viewmodel/LoginViewModel$LoginState;", "()V", "app_debug"})
        public static final class Loading extends com.mining.safety.viewmodel.LoginViewModel.LoginState {
            @org.jetbrains.annotations.NotNull
            public static final com.mining.safety.viewmodel.LoginViewModel.LoginState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/mining/safety/viewmodel/LoginViewModel$LoginState$Success;", "Lcom/mining/safety/viewmodel/LoginViewModel$LoginState;", "response", "Lcom/mining/safety/model/LoginResponse;", "(Lcom/mining/safety/model/LoginResponse;)V", "getResponse", "()Lcom/mining/safety/model/LoginResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Success extends com.mining.safety.viewmodel.LoginViewModel.LoginState {
            @org.jetbrains.annotations.NotNull
            private final com.mining.safety.model.LoginResponse response = null;
            
            public Success(@org.jetbrains.annotations.NotNull
            com.mining.safety.model.LoginResponse response) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.mining.safety.model.LoginResponse getResponse() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.mining.safety.model.LoginResponse component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.mining.safety.viewmodel.LoginViewModel.LoginState.Success copy(@org.jetbrains.annotations.NotNull
            com.mining.safety.model.LoginResponse response) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override
            @org.jetbrains.annotations.NotNull
            public java.lang.String toString() {
                return null;
            }
        }
    }
}