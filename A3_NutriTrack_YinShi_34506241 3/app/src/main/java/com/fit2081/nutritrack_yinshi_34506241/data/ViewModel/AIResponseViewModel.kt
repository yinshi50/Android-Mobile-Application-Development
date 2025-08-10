package com.fit2081.nutritrack_yinshi_34506241.data.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.fit2081.nutritrack_yinshi_34506241.data.AI.AIResponse
import com.fit2081.nutritrack_yinshi_34506241.data.Repository.AIResponseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AIResponseViewModel(application: Application): AndroidViewModel(application) {
    private val aiResponseRepository = AIResponseRepository(application.applicationContext)

    private val _aiResponseListOrderDateTime = MutableStateFlow<List<AIResponse>>(emptyList())
    val aiResponseListOrderDateTime: StateFlow<List<AIResponse>> = _aiResponseListOrderDateTime

    fun getAIResponseOrderDateTime(userID: String) = viewModelScope.launch {
        aiResponseRepository.getAIResponsesByDateTime(userID).collect {
            _aiResponseListOrderDateTime.value = it
        }
    }

    private val _aiResponseListOrderId = MutableStateFlow<List<AIResponse>>(emptyList())
    val aiResponseListOrderId: StateFlow<List<AIResponse>> = _aiResponseListOrderId

    fun getAIResponseOrderId(userID: String) = viewModelScope.launch {
        aiResponseRepository.getAIResponsesById(userID).collect {
            _aiResponseListOrderId.value = it
        }
    }

    fun insertAIResponse(aiResponse: AIResponse) = viewModelScope.launch {
        aiResponseRepository.insertAIResponse(aiResponse)
    }

    fun deleteAIResponse(aiResponse: AIResponse) = viewModelScope.launch {
        aiResponseRepository.deleteAIResponse(aiResponse)
    }
}