package com.example.jetpackcomposeassess.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.jetpackcomposeassess.data.model.Model
import com.example.jetpackcomposeassess.data.model.Name
import com.example.jetpackcomposeassess.data.model.Result
import com.example.jetpackcomposeassess.ui.theme.JetpackcomposeAssessTheme
import com.example.jetpackcomposeassess.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : ComponentActivity() {


    val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeAssessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    DetailScreen(userViewModel = userViewModel)
                }
            }
        }

        userViewModel.getAllUserInfo()
    }


    val dummyUsers = arrayListOf(Model(
        info = null,
        results = arrayListOf(
            Result(
                name = Name("sam", "och", "oka"),
                email = "esss@gmail.com",
                location = null,
                cell = null,
                dob = null,
                id = null,
                nat = null,
                phone = null,
                picture = null,
                registered = null,
                login = null
            )
        )
    ),
        Model(
            info = null,
            results = arrayListOf(
                Result(
                    name = Name("sam", "och", "oka"),
                    email = "esss@gmail.com",
                    location = null,
                    cell = null,
                    dob = null,
                    id = null,
                    nat = null,
                    phone = null,
                    picture = null,
                    registered = null,
                    login = null
                )
            )
        ))
}