package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentScoreBinding
import com.example.myapplication.databinding.FragmentTitleBinding

class ScoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentScoreBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)
        binding.scoreTextView.text = ScoreFragmentArgs.fromBundle(requireArguments()).score.toString()

        binding.playAgainButton.setOnClickListener{
            findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToGameFragment())
        }

        return binding.root
    }

}