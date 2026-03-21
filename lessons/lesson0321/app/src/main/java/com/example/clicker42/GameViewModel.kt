package com.example.clicker42

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    var score by mutableStateOf(0f)
    var perClick by mutableStateOf(1.2f)

    fun OnTap(){
        score += perClick
    }
}