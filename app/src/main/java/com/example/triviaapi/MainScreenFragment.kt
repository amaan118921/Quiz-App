package com.example.triviaapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.triviaapi.databinding.FragmentMainScreenBinding
import com.example.triviaapi.model.QuizViewModel


class MainScreenFragment : Fragment() {

    private var binding: FragmentMainScreenBinding? = null


    private val Model: QuizViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentMainScreenBinding.inflate(inflater)
        binding = fragmentBinding
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            quizModel = Model
            questionNumber.text = 1.toString()
            toHome.setOnClickListener {
                Model.allClear()
                findNavController().navigate(R.id.action_mainScreenFragment_to_homeFragment)
            }
//
//            nextButton.setOnClickListener {
//
//                if(Model.number==4) {
//                    val action = MainScreenFragmentDirections.actionMainScreenFragmentToResultsFragment()
//                    nextButton.findNavController().navigate(action)
//                }
//                else {
//                    questionNumber.text = (Model.number + Model.num).toString()
//                    Model.getQuiz(Model.incNumber())
//                }
//
//            }

            b1.setOnClickListener {
                Model.isCorrect(b1.text.toString())
                if(Model.number==4) {
                    findNavController().navigate(R.id.action_mainScreenFragment_to_resultsFragment)
                }
                questionNumber.text = (Model.number + Model.num).toString()
                Model.getQuiz(Model.incNumber())

            }
            b2.setOnClickListener {
                Model.isCorrect(b2.text.toString())
                if(Model.number==4) {
                    findNavController().navigate(R.id.action_mainScreenFragment_to_resultsFragment)
                }
                questionNumber.text = (Model.number + Model.num).toString()
                Model.getQuiz(Model.incNumber())
            }
            b3.setOnClickListener {
                Model.isCorrect(b3.text.toString())
                if(Model.number==4) {
                    findNavController().navigate(R.id.action_mainScreenFragment_to_resultsFragment)
                }
                questionNumber.text = (Model.number + Model.num).toString()
                Model.getQuiz(Model.incNumber())
            }
            b4.setOnClickListener {
                Model.isCorrect(b4.text.toString())
                if(Model.number==4) {
                    findNavController().navigate(R.id.action_mainScreenFragment_to_resultsFragment)
                }
                questionNumber.text = (Model.number + Model.num).toString()
                Model.getQuiz(Model.incNumber())
            }
        }

    }


}
