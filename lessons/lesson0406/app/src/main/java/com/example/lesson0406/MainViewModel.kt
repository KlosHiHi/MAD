package com.example.lesson0406

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson0406.data.MarsPhoto
import com.example.lesson0406.data.MarsRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var list = mutableStateOf(listOf<MarsPhoto>())
    val repository = MarsRepository()

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos(){
        viewModelScope.launch {
            list = repository.getMarsPhotos() as MutableState<List<MarsPhoto>>
        }
    }
}