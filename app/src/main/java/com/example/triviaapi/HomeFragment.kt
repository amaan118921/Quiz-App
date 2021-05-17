package com.example.triviaapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.triviaapi.databinding.FragmentHomeBinding
import com.example.triviaapi.model.QuizViewModel


class HomeFragment : Fragment() {
    private val Model: QuizViewModel by activityViewModels()
    private var binding: FragmentHomeBinding? = null

    private fun navigate() {
        findNavController().navigate(R.id.action_homeFragment_to_optionsFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentHomeBinding.inflate(inflater)
        binding = fragmentBinding
        binding?.apply {
            viewModel = Model
        }
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.apply {
//           homeStartButton.setOnClickListener{
//               findNavController().navigate(R.id.action_homeFragment_to_optionsFragment)            }
//        }
            history.setOnClickListener {
                Model.setCategory(23)
                navigate()
            }
            sports.setOnClickListener {
                Model.setCategory(21)
                navigate()
            }
            Geography.setOnClickListener {
                Model.setCategory(22)
                navigate()
            }
            generalKnowledge.setOnClickListener {
                Model.setCategory(9)
                navigate()
            }
//            politics.setOnClickListener {
//                Model.setCategory(24)
//               navigate()
//            }
        }

    }
}