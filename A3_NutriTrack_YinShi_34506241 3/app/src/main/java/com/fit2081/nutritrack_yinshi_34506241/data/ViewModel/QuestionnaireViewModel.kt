package com.fit2081.nutritrack_yinshi_34506241.data.ViewModel

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.fit2081.nutritrack_yinshi_34506241.data.Questionnaire.QuestionnaireAnswers
import com.fit2081.nutritrack_yinshi_34506241.data.Repository.QuestionnaireRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuestionnaireViewModel(context: Context): ViewModel() {
    private val questionnaireRepository = QuestionnaireRepository(context)

    private val _questionnaire = mutableStateOf<QuestionnaireAnswers?>(null)
    val questionnaireViewModel: State<QuestionnaireAnswers?> = _questionnaire

    fun getQuestionnaireById(id: String){
        viewModelScope.launch(Dispatchers.IO) {
            val result = questionnaireRepository.getQuestionnaireById(id)
            withContext(Dispatchers.Main) {
                _questionnaire.value = result
            }
        }
    }

    fun insertQuestionnaire(questionnaire: QuestionnaireAnswers) {
        viewModelScope.launch(Dispatchers.IO) {
            questionnaireRepository.insertQuestionnaire(questionnaire)
        }
    }

    fun deleteQuestionnaire(questionnaire: QuestionnaireAnswers) {
        viewModelScope.launch(Dispatchers.IO) {
            questionnaireRepository.deleteQuestionnaire(questionnaire)
        }
    }

    fun updateQuestionnaire(questionnaire: QuestionnaireAnswers) {
        viewModelScope.launch(Dispatchers.IO) {
            questionnaireRepository.updateQuestionnaire(questionnaire)
        }
    }

    class QuestionnaireFactory(context: Context) : ViewModelProvider.Factory {
        private val context = context.applicationContext
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            QuestionnaireViewModel(context) as T
    }

}