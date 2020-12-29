package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentGameBinding
import com.example.myapplication.databinding.FragmentTitleBinding

class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        initButtons(binding)

        binding.apply {
            viewModel.currentWord.observe(viewLifecycleOwner, { word -> wordTextView.text = word})
        }
        return binding.root
    }

    private fun initButtons(binding: FragmentGameBinding) {
        binding.apply {
            endGameButton.setOnClickListener { onGameFinish() }
            skipButton.setOnClickListener { onSkip() }
            gotItButton.setOnClickListener { onCorrect() }
        }
    }

    private fun onSkip() {
        viewModel.onSkip()
    }

    private fun onCorrect() {
        viewModel.onCorrect()
    }

    private fun onGameFinish() {
        val action = GameFragmentDirections.actionGameFragmentToScoreFragment()
        action.score = viewModel.currentScore.value ?: 0
        findNavController().navigate(action)
    }

}