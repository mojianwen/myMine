package com.mining.safety.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mining.safety.model.Material
import com.mining.safety.model.PageResponse
import com.mining.safety.repository.MaterialRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MaterialViewModel : ViewModel() {

    private val materialRepository = MaterialRepository()

    private val _materialList = MutableStateFlow<List<Material>>(emptyList())
    val materialList: StateFlow<List<Material>> = _materialList

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private var currentPage = 1
    private val pageSize = 10

    init {
        loadMaterialList()
    }

    fun loadMaterialList() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = materialRepository.getMaterialList(currentPage, pageSize)
            result.fold(
                onSuccess = { response: PageResponse<Material> ->
                    _materialList.value = response.records
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun addMaterial(material: Material) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = materialRepository.addMaterial(material)
            result.fold(
                onSuccess = {
                    loadMaterialList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun updateMaterial(material: Material) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = materialRepository.updateMaterial(material)
            result.fold(
                onSuccess = {
                    loadMaterialList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }

    fun deleteMaterial(id: Long) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = materialRepository.deleteMaterial(id)
            result.fold(
                onSuccess = {
                    loadMaterialList()
                },
                onFailure = { error ->
                    _error.value = error.message
                }
            )
            _loading.value = false
        }
    }
}
