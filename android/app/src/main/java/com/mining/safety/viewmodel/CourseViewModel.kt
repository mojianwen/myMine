package com.mining.safety.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mining.safety.model.Course
import com.mining.safety.model.PageResponse
import com.mining.safety.repository.CourseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CourseViewModel : ViewModel() {

    private val courseRepository = CourseRepository()

    private val _courseList = MutableStateFlow<List<Course>>(emptyList())
    val courseList: StateFlow<List<Course>> = _courseList

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private var currentPage = 1
    private val pageSize = 10

    init {
        loadCourseList()
    }

    fun loadCourseList() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = courseRepository.getCourseList(currentPage, pageSize)
            result.fold(
                onSuccess = { response: PageResponse<Course> ->
                    _courseList.value = response.records
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun addCourse(course: Course) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = courseRepository.addCourse(course)
            result.fold(
                onSuccess = {
                    loadCourseList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun updateCourse(course: Course) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = courseRepository.updateCourse(course)
            result.fold(
                onSuccess = {
                    loadCourseList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun deleteCourse(id: Long) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = courseRepository.deleteCourse(id)
            result.fold(
                onSuccess = {
                    loadCourseList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }
}
