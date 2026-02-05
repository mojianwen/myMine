package com.mining.safety.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mining.safety.model.Classroom
import com.mining.safety.model.PageResponse
import com.mining.safety.repository.ClassroomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClassroomViewModel : ViewModel() {

    private val classroomRepository = ClassroomRepository()

    private val _classroomList = MutableStateFlow<List<Classroom>>(emptyList())
    val classroomList: StateFlow<List<Classroom>> = _classroomList

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private var currentPage = 1
    private val pageSize = 10

    init {
        loadClassroomList()
    }

    fun loadClassroomList() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = classroomRepository.getClassroomList(currentPage, pageSize)
            result.fold(
                onSuccess = { response: PageResponse<Classroom> ->
                    _classroomList.value = response.records
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun addClassroom(classroom: Classroom) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = classroomRepository.addClassroom(classroom)
            result.fold(
                onSuccess = {
                    loadClassroomList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun updateClassroom(classroom: Classroom) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = classroomRepository.updateClassroom(classroom)
            result.fold(
                onSuccess = {
                    loadClassroomList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun deleteClassroom(id: Long) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = classroomRepository.deleteClassroom(id)
            result.fold(
                onSuccess = {
                    loadClassroomList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun signClassroom(id: Long) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = classroomRepository.signClassroom(id)
            result.fold(
                onSuccess = {
                    loadClassroomList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }
}
