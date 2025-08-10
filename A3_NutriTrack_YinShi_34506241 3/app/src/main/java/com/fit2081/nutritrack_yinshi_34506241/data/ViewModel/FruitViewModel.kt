package com.fit2081.nutritrack_yinshi_34506241.data.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.fit2081.nutritrack_yinshi_34506241.data.Fruit.FruitResponse
import com.fit2081.nutritrack_yinshi_34506241.data.Repository.FruitRepository
import com.fit2081.nutritrack_yinshi_34506241.ui.UiStates.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FruitViewModel(application: Application): AndroidViewModel(application) {
    private val fruitRepository = FruitRepository(application.applicationContext)
    private val _fruit = MutableStateFlow<FruitResponse?>(null)
    val fruit: StateFlow<FruitResponse?> = _fruit
    private val _uiState = MutableStateFlow<UiState>(UiState.Initial)
    val uiState: StateFlow<UiState> = _uiState

    fun getFruit(name: String){
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            try {
                if (fruitRepository.isNetworkAvailable()) {
                    try {
                        val response = fruitRepository.getFruit(name)
                        if (response != null) {
                            _uiState.value = UiState.Success(response.toString())
                            _fruit.value = response
                        } else {
                            _uiState.value = UiState.Error("Fruit not found")
                        }
                    } catch (e: Exception) {
                        _uiState.value = UiState.Error(e.localizedMessage ?: "Unexpected error")
                    }
                }else{
                    _uiState.value = UiState.NetworkError("No internet connection")
                }
            } catch (e: Exception) {
                // Handle error
                _uiState.value = UiState.Error(e.localizedMessage ?: "Unexpected error")
            }
        }
    }

}