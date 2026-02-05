package com.mining.safety.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mining.safety.model.LoginResponse
import com.mining.safety.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun onUsernameChange(value: String) {
        _username.value = value
    }

    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun login() {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            val result = userRepository.login(_username.value, _password.value)
            result.fold(
                onSuccess = { response ->
                    _loginState.value = LoginState.Success(response)
                },
                onFailure = { error ->
                    _loginState.value = LoginState.Error(error.message ?: "登录失败")
                }
            )
        }
    }

    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        data class Success(val response: LoginResponse) : LoginState()
        data class Error(val message: String) : LoginState()
    }
}
