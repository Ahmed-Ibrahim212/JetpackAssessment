package com.example.jetpackcomposeassess.view

class PasswordState: TextFieldState(
    validator = :: isPasswordValid,
    errorMessage =  ::passwordErrorMessage
)

fun isPasswordValid (password: String ) = password.length>=6

fun passwordErrorMessage(message: String)= "Password $message is invalid"

