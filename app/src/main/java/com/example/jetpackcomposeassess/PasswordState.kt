package com.example.jetpackcomposeassess

class PasswordState: TextFieldState(
    validator = :: isPasswordValid,
    errorMessage =  ::passwordErrorMessage
)

fun isPasswordValid (password: String ) = password.length>=6

fun passwordErrorMessage(message: String)= "Password $message is invalid"

