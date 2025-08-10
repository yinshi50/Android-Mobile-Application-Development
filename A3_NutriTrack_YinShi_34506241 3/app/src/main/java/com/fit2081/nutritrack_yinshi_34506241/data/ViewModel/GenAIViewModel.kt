package com.fit2081.nutritrack_yinshi_34506241.data.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.fit2081.nutritrack_yinshi_34506241.BuildConfig
import com.fit2081.nutritrack_yinshi_34506241.ui.UiStates.UiState

class GenAIViewModel : ViewModel() {
    private val _uiStateTips: MutableStateFlow<UiState> =
        MutableStateFlow(UiState.Initial)
    val uiStateTips: StateFlow<UiState> =
        _uiStateTips.asStateFlow()

    private val _uiStateFeedback: MutableStateFlow<UiState> =
        MutableStateFlow(UiState.Initial)
    val uiStateFeedback: StateFlow<UiState> =
        _uiStateFeedback.asStateFlow()

    private val _uiStatePattern: MutableStateFlow<UiState> =
        MutableStateFlow(UiState.Initial)
    val uiStatePattern: StateFlow<UiState> =
        _uiStatePattern.asStateFlow()

    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = "AIzaSyA47wayhgJdLEMNI-lbKExtHfpx4roL39I"
    )

    fun sendPrompt(
        prompt: String, type: String
    ) {
        if (type == "Tips"){
            _uiStateTips.value = UiState.Loading
        } else if(type == "Feedback"){
            _uiStateFeedback.value = UiState.Loading
        } else{
            _uiStatePattern.value = UiState.Loading
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = generativeModel.generateContent(
                    content {
                        text(prompt)
                    }
                )
                response.text?.let { outputContent ->
                    if (type == "Tips"){
                        _uiStateTips.value = UiState.Success(outputContent)
                    } else if (type == "Feedback"){
                        _uiStateFeedback.value = UiState.Success(outputContent)
                    } else{
                        _uiStatePattern.value = UiState.Success(outputContent)
                    }
                }
            } catch (e: Exception) {
                if (type == "Tips"){
                    _uiStateTips.value = UiState.Error(e.localizedMessage ?: "")
                } else if(type == "Feedback"){
                    _uiStateFeedback.value = UiState.Error(e.localizedMessage ?: "")
                } else{
                    _uiStatePattern.value = UiState.Error(e.localizedMessage ?: "")
                }
            }
        }
    }
}