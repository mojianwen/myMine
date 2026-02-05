package com.mining.safety.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mining.safety.model.Exam
import com.mining.safety.model.PageResponse
import com.mining.safety.repository.ExamRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExamViewModel : ViewModel() {

    private val examRepository = ExamRepository()

    private val _examList = MutableStateFlow<List<Exam>>(emptyList())
    val examList: StateFlow<List<Exam>> = _examList

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private var currentPage = 1
    private val pageSize = 10

    init {
        loadExamList()
    }

    fun loadExamList() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = examRepository.getExamList(currentPage, pageSize)
            result.fold(
                onSuccess = { response: PageResponse<Exam> ->
                    _examList.value = response.records
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun addExam(exam: Exam) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = examRepository.addExam(exam)
            result.fold(
                onSuccess = {
                    loadExamList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun updateExam(exam: Exam) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = examRepository.updateExam(exam)
            result.fold(
                onSuccess = {
                    loadExamList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun deleteExam(id: Long) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = examRepository.deleteExam(id)
            result.fold(
                onSuccess = {
                    loadExamList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }
}
