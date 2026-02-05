package com.mining.safety.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mining.safety.model.PageResponse
import com.mining.safety.model.User
import com.mining.safety.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private val _userList = MutableStateFlow<List<User>>(emptyList())
    val userList: StateFlow<List<User>> = _userList

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private var currentPage = 1
    private val pageSize = 10

    init {
        loadUserList()
    }

    fun loadUserList() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = userRepository.getUserList(currentPage, pageSize)
            result.fold(
                onSuccess = { response: PageResponse<User> ->
                    _userList.value = response.records
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = userRepository.addUser(user)
            result.fold(
                onSuccess = {
                    loadUserList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = userRepository.updateUser(user)
            result.fold(
                onSuccess = {
                    loadUserList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun deleteUser(id: Long) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = userRepository.deleteUser(id)
            result.fold(
                onSuccess = {
                    loadUserList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }
}
