package com.example.jetpackcomposeassess

import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue



open class TextFieldState (
    private val validator: (String)-> Boolean = {false},
    private val errorMessage: (String) -> String
        ){
    var text by mutableStateOf("")
    var error by mutableStateOf<String?>(null)

    init {
        validate()
    }

    fun validate(){
        error = if (validator(text)){
            null
        } else if (text.isEmpty()){
            errorMessage("is empty")
        }else{
            errorMessage(text)
        }

    }
}

