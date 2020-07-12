package com.zenith.quizapp.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zenith.quizapp.model.Question

@Database(entities = [Question::class],version = 1,exportSchema = false)
abstract class QuizDatabase: RoomDatabase() {
    abstract fun quizDao():QuizDao
}