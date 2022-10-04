package com.example.jetpackcomposeassess

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeassess.data.model.Model
import com.example.jetpackcomposeassess.viewmodel.UserViewModel

@Composable
fun DetailScreen(
    userViewModel: UserViewModel
) {

    val users: List<Model> by  userViewModel.searchedName.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp, 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Search",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontFamily = FontFamily.Default,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(20.dp))


        SearchBar(
            hint = "Search for name",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        onSearch = {
            userViewModel.searchFilter.value = it
        }
        )

        Spacer(modifier = Modifier.height(1.dp))

        users.map {
            UserDetail(model = it)
        }

    }
}


@Composable
fun UserDetail(
    model: Model
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(6.dp, 6.dp),
    ) {


        Text(
            text = "${model.results.get(0).name?.first} ${model.results.get(0).name?.last}"  ?: "",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontFamily = FontFamily.Default,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(6.dp))


        Text(
            text = model.results.get(0).email ?: "",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontFamily = FontFamily.Default,
            fontSize = 16.sp
        )

        Text(
            text = model.results.get(0).location?.street?.name ?: "SHOWNAME",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontFamily = FontFamily.Default,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider(
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String)-> Unit
) {
    var text by remember {
    mutableStateOf("")
}
    var isHintDisplayed by remember {
        mutableStateOf(true)
    }
    Box(modifier = modifier){
        BasicTextField(value = text, onValueChange = {
            text = it
            onSearch(it)
            if (it.isNotEmpty()){
                isHintDisplayed = false
            }
        },
        maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color =Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(color = Color.LightGray, RoundedCornerShape(5.dp))
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged { }
            )
        if (isHintDisplayed){
            Text(text = hint,
            color = Color.White,
            modifier = Modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 12.dp
                ))
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun DetailScreenPreview() {
//    DetailScreen(arrayListOf())
//}