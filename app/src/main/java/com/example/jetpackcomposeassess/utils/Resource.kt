package com.example.jetpackcomposeassess.utils

import com.example.jetpackcomposeassess.data.model.Model


sealed class Resource<out T> {
    data class Success<out T>(val value: T): Resource<T>()
    data class Error(val code: Int? = null, val error: String): Resource<Nothing>()
    data class Loading<out T>(val data: T? = null, val message: String? =null): Resource<T>()

}