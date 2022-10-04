package com.example.jetpackcomposeassess.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeassess.data.model.Model
import com.example.jetpackcomposeassess.data.repository.AuthRepository
import com.example.jetpackcomposeassess.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val authRepository: AuthRepository): ViewModel() {
    private var _userList = MutableStateFlow<List<Model>>(arrayListOf())
    val userList = _userList.asStateFlow()
    val searchFilter = MutableStateFlow("")



    //search View
    val searchedName = userList.combine(
        searchFilter
    ) { userList, searchFilter ->
        userList.filter {
            it.results.get(0).name?.first?.lowercase()?.contains(searchFilter.lowercase()) == true ||
                    it.results.get(0).name?.last?.lowercase()?.contains(searchFilter.lowercase()) == true }
    }

    fun getAllUserInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            for (i in 0..2){
                val result = authRepository.getUserInfo()
                (handleResponse(result))
            }

        }

    }

    private fun handleResponse(userData: Response<Model>): Resource<Model> {
        if (userData.isSuccessful) {
            userData.body()?.let { data ->
                _userList.value = _userList.value + data
                return Resource.Success(data)
            }
        }
        return Resource.Error(null, userData.message())
    }
}