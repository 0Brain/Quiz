package com.zenith.quizapp.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zenith.quizapp.model.Question


@Dao
interface QuizDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions:List<Question>)

    @Query("SELECT * FROM questions_table WHERE id = :id")
    suspend fun getQuestionByID(id:Int):Question

    @Query("SELECT * FROM questions_table")
    suspend fun getAllQuestions():List<Question>

}