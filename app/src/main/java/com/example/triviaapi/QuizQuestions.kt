package com.example.triviaapi

import com.squareup.moshi.Json

data class QuizQuestions(
    val question: String, @Json(name="correct_answer")val correctAnswer: String,
    @Json(name="incorrect_answers") val incorrectAnswer: MutableList<String>
)

data class JsonResponse(
    val results: List<QuizQuestions>
)

data class Incorrect(
 val I: String
)