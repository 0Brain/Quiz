package com.zenith.quizapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zenith.quizapp.model.Question
import com.zenith.quizapp.persistance.QuizDao
import com.zenith.quizapp.persistance.datasource.Questions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val quizDao: QuizDao
) {

    private val questionFromDataSource: MutableList<Question> = Questions.getQuestions()


    fun getAllQuestions(): LiveData<List<Question>> {
        val questionsListLiveData = MutableLiveData<List<Question>>()
        if (questionsListLiveData.value == null) {
            GlobalScope.launch(Dispatchers.IO) {
                if (quizDao.getAllQuestions().isEmpty()) {
                    quizDao.insertQuestions(questionFromDataSource)
                }
                val questionsFromDb = async {
                    return@async quizDao.getAllQuestions()
                }.await()
                questionsListLiveData.postValue(questionsFromDb)
            }
        } else {
            return questionsListLiveData
        }
        return questionsListLiveData
    }

    fun getQuestionById(questionId: Int): LiveData<Question> {
        val questionsListLiveData = MutableLiveData<Question>()
        if (questionsListLiveData.value == null) {
            GlobalScope.launch(Dispatchers.IO) {
                if (quizDao.getAllQuestions().isEmpty()) {
                    quizDao.insertQuestions(questionFromDataSource)
                }
                val questionFromDb = async {
                    return@async quizDao.getQuestionByID(questionId)
                }.await()
                questionsListLiveData.postValue(questionFromDb)
            }
        } else {
            return questionsListLiveData
        }
        return questionsListLiveData
    }
}