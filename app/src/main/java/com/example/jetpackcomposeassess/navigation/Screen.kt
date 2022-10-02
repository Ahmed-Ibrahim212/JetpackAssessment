package com.example.jetpackcomposeassess.navigation

sealed class Screen(val route: String){
    object LoginScreen: Screen("Login_Screen")
    object DetailScreen: Screen ("Detail_Screen")
}
