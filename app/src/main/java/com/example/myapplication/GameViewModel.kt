package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _currentWord = MutableLiveData<String>()
    val currentWord: LiveData<String>
        get() = _currentWord

    private val _currentScore = MutableLiveData<Int>()
    val currentScore: LiveData<Int>
        get() = _currentScore

    private lateinit var wordList: MutableList<String>

    init {
        resetList()
        nextWord()
        _currentScore.value = 0
    }

    fun onSkip() {
        _currentScore.value = _currentScore.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _currentScore.value = _currentScore.value?.plus(1)
        nextWord()
    }

    private fun resetList() {
        wordList = mutableListOf("dog", "cat", "duck", "cow", "desk", "car")
        wordList.shuffle()
    }

    private fun nextWord() {
        if (wordList.isEmpty()) {
            resetList()
        } else {
            _currentWord.value = wordList.removeAt(0)
        }
    }
}