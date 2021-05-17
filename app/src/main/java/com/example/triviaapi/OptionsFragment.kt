package com.example.triviaapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.triviaapi.databinding.FragmentOptionsBinding
import com.example.triviaapi.model.QuizViewModel

class OptionsFragment : Fragment() {
    private var binding : FragmentOptionsBinding? = null


    private val Model : QuizViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
         val fragmentBinding = FragmentOptionsBinding.inflate(inflater)
        binding = fragmentBinding
        binding?.apply {
            viewModel = Model
        }
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
            easyButton.setOnClickListener{
                Model.setDifficulty(Model.easy)
                Model.getQuiz(Model.incNumber())
                findNavController().navigate(R.id.action_optionsFragment_to_mainScreenFragment)
            }
            hardButton.setOnClickListener {
                Model.setDifficulty(Model.hard)
                Model.getQuiz(Model.incNumber())
                findNavController().navigate(R.id.action_optionsFragment_to_mainScreenFragment)
            }
        }
    }



}