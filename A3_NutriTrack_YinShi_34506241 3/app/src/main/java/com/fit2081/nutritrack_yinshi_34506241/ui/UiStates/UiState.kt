package com.fit2081.nutritrack_yinshi_34506241.ui.UiStates

sealed interface UiState {
    data object Initial: UiState
    data object Loading : UiState
    data class Success(val outputText: String) : UiState
    data class Error(val errorMessages: String) : UiState
    data class NetworkError(val errorMessages: String) : UiState
}

