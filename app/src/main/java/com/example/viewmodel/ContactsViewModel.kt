package com.example.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ContactsViewModel( val text :String ) : ViewModel(){

    var backgroundColor by mutableStateOf(false)
        private set
    fun changeBackgroundColor(){
        backgroundColor = !backgroundColor
    }
}