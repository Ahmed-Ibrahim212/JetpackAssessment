package com.example.jetpackcomposeassess

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeassess.ui.theme.JetpackcomposeAssessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            JetpackcomposeAssessTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                   LoginScreen {
                     startActivity(
                         Intent(this, DetailsActivity::class.java)
                     )
                   }
                }
            }


        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackcomposeAssessTheme {
        Greeting("Android")
    }
}

//if (email.value.isEmpty() && password.value.isNotEmpty()){
//    Toast.makeText(context, "Email is Empty", Toast.LENGTH_LONG).show()
//}
//if (password.value.isEmpty() && email.value.isNotEmpty()){
//    Toast.makeText(context,"Password is Empty", Toast.LENGTH_SHORT).show()
//}
//if (email.value.isEmpty() && password.value.isEmpty()){
//
//    Toast.makeText(context,"Email and Password are empty", Toast.LENGTH_SHORT).show()
//}
//if (email.value.isNotEmpty()&& password.value.isNotEmpty()){
//    Toast.makeText(context,"Successfully Login", Toast.LENGTH_SHORT).show()
//}