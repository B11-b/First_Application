package com.ba.first_application.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ba.first_application.core.model.repo.LoginRepo
import com.ba.first_application.core.model.responce.UserResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel:ViewModel() {
    var loginData : MutableLiveData<Response<UserResponse>> = MutableLiveData()
    val repo=LoginRepo()
    fun startLogin(username:String,password:String){
     viewModelScope.launch {
       loginData.postValue(repo.login(username, password))
     }

    }
}