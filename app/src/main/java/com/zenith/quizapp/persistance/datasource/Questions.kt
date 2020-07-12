package com.zenith.quizapp.persistance.datasource

import com.zenith.quizapp.model.Question

object Questions {
    fun getQuestions(): MutableList<Question> {
        val questionsList: MutableList<Question> = ArrayList()

        val question1 = Question(
            "Which of these seek badges  for \"Budging,\" \"Flying Fish\" and \"Weather\"",
            "Candy Crush Players",
            "MENSA members",
            "Girl Scouts",
            "Boy Scouts",
            2
        )
        questionsList.add(question1)

        val question2 = Question(
            "Backyard kingdom of castle builders and sediment shoveler",
            "A treehouse",
            "The swimming pool",
            "The snow fort",
            "The sandbox",
            4
        )
        questionsList.add(question2)
        val question3 = Question(
            "Mario's older brother",
            "King Koopa",
            "Pikachu",
            "Luigi",
            "Grover",
            3
        )
        questionsList.add(question3)

        questionsList.add(question2)
        val question4 = Question(
            "Quadrants are numbered in this ball game",
            "Tic-tac-toe",
            "Basketball",
            "Four square",
            "Tetherball",
            3
        )
        questionsList.add(question4)

        val question5 = Question(
            "Two player,puck pushing table-top sport",
            "Pinball",
            "Checkers",
            "Air hockey",
            "Donkey kong",
            3
        )
        questionsList.add(question5)

        return questionsList
    }
}