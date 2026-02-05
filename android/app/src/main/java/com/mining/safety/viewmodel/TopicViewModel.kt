package com.mining.safety.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mining.safety.model.PageResponse
import com.mining.safety.model.Topic
import com.mining.safety.repository.TopicRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TopicViewModel : ViewModel() {

    private val topicRepository = TopicRepository()

    private val _topicList = MutableStateFlow<List<Topic>>(emptyList())
    val topicList: StateFlow<List<Topic>> = _topicList

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private var currentPage = 1
    private val pageSize = 10

    init {
        loadTopicList()
    }

    fun loadTopicList() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = topicRepository.getTopicList(currentPage, pageSize)
            result.fold(
                onSuccess = { response: PageResponse<Topic> ->
                    _topicList.value = response.records
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun addTopic(topic: Topic) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = topicRepository.addTopic(topic)
            result.fold(
                onSuccess = {
                    loadTopicList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun updateTopic(topic: Topic) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = topicRepository.updateTopic(topic)
            result.fold(
                onSuccess = {
                    loadTopicList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun deleteTopic(id: Long) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = topicRepository.deleteTopic(id)
            result.fold(
                onSuccess = {
                    loadTopicList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }
}
