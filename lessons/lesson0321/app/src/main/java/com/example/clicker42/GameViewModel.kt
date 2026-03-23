package com.example.clicker42

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    var score by mutableStateOf(0)
    var perClick by mutableStateOf(1)

    fun OnTap(){
        score += perClick
    }
}