package com.example.triviaapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.triviaapi.databinding.FragmentResultsBinding
import com.example.triviaapi.model.QuizViewModel

class ResultsFragment : Fragment() {
    private val Model: QuizViewModel by activityViewModels()
     private var binding : FragmentResultsBinding? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentBinding = FragmentResultsBinding.inflate(inflater)
        binding = fragmentBinding
        return  fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
            score2.text = Model.score.toString()
            home.setOnClickListener{
                Model.allClear()
                findNavController().navigate(R.id.action_resultsFragment_to_homeFragment)
            }
        }
    }




}