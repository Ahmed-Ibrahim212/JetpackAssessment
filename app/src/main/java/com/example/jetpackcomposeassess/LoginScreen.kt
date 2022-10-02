package com.example.jetpackcomposeassess

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onClick: () -> Unit
) {

    val email = remember { (EmailState()) }
    val password = remember { PasswordState() }


    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Login",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            fontSize = 35.sp,
        )
        Spacer(modifier = Modifier.height(100.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = email.text,
            onValueChange = {
                email.text = it
                email.validate()
            },
            singleLine = true,
            label = { Text(text = stringResource(id = R.string.email_hint)) },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = email.error != null && !(email.error?.contains("is empty") == true),
        )

        Spacer(modifier = Modifier.height(20.dp))
     email.error?.let {
         if (!it.contains("is empty")){
             ErrorField(it)
         }

        }

        OutlinedTextField(
            value = password.text,
            onValueChange = {
                password.text = it
                password.validate()
            },
            shape = RoundedCornerShape(10.dp),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            label = { Text(text = stringResource(id = R.string.password_hint)) },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth(),
            isError = password.error != null && !(password.error?.contains("is empty") == true)
        )
        password.error?.let {
            if (!it.contains("is empty")){
                ErrorField(it)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = {

                if (email.error == null && password.error == null){
                    Log.d("ITSOED", "IT email ? ${email.error != null} password ? ${password.error != null}")
                    onClick()
                }
            }   ,
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(
                text = "Login",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

        }

    }
}

@Composable
fun ErrorField(error: String) {
    Text(
        text = error,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(color = MaterialTheme.colors.error)
    )
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    LoginScreen(onClick = {})
}