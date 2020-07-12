package com.zenith.quizapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zenith.quizapp.model.Question
import com.zenith.quizapp.repository.MainRepository

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
):ViewModel() {

    fun getAllQuestions():LiveData<List<Question>>{
        return mainRepository.getAllQuestions()
    }
}