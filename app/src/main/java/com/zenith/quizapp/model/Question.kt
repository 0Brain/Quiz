package com.zenith.quizapp.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "questions_table")
data class Question(
    @ColumnInfo(name = "question_value") val question: String,
    @ColumnInfo(name = "option1_value") val optionOne: String,
    @ColumnInfo(name = "option2_value") val optionTwo: String,
    @ColumnInfo(name = "option3_value") val optionThree: String,
    @ColumnInfo(name = "option4_value") val optionFour: String,
    @ColumnInfo(name = "correct_value") val correctAnswer: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}