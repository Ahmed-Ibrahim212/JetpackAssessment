package com.example.jetpackcomposeassess.data.model

data class Login(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1 : String,
    val username: String,
    val uuid: String
)