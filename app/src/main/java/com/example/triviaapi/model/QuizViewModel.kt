package com.example.triviaapi.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapi.JsonResponse
import com.example.triviaapi.QuizQuestions
import com.example.triviaapi.network.Api
import com.example.triviaapi.network.ApiService
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {
     val num = 2
     var score  = 0
     val easy = "easy"
     val hard = "hard"
     var number = -1

     fun incNumber() : Int
     {
         number++
         return number
     }
        private var _correctAnswer = ""

    private var _question = MutableLiveData<String>("")
     val question: LiveData<String> = _question
    private var difficulty: String = ""

    private var _optionList = MutableLiveData<MutableList<String>>(mutableListOf())
    val optionList: LiveData<MutableList<String>> = _optionList

    private var category: Int = 0





    fun setCategory(category: Int)
    {
        this.category = category
    }
    fun setDifficulty(difficulty: String)
    {
        this.difficulty = difficulty
    }

    fun isCorrect(answer: String) {
        if(answer==_correctAnswer) {
            score += 10
        }
    }

    fun allClear() {
        number = -1
        score = 0
    }
     fun getQuiz(number: Int)
    {

                viewModelScope.launch {
                    Api.retrofitService.getQuestions("multiple", difficulty, category, 10).apply {
                        _question.value = results[number].question
                        _correctAnswer = results[number].correctAnswer
                        _optionList.value = results[number].incorrectAnswer
                        _optionList.value!!.add(_correctAnswer)
                        _optionList.value!!.shuffle()


                    }

            }


    }

}