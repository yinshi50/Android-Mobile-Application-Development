package com.fit2081.nutritrack_yinshi_34506241.data.User

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object AuthManager {
    val _userId: MutableState<String?> = mutableStateOf(null)

    fun login(userId: String) {
        _userId.value = userId
    }

    fun logout(){
        _userId.value = null
    }

    fun getId(): String? {
        return _userId.value
    }
}