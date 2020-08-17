package com.rove.androidinternshipproject.MVVM

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*Created by Talha Siddiqui on 17/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class UserViewModel(private val userRepository: UserRepositoryInterface) : ViewModel() {

    private val user: MutableLiveData<Resource<UserModel>> by lazy {
        MutableLiveData<Resource<UserModel>>().also {
            loadUser(it) //Have to pass this to method otherwise user is not initialised yet
        }
    }

    //private val user: MutableLiveData<Resource<UserModel>> =  MutableLiveData<Resource<UserModel>>()

    fun getUsers(): LiveData<Resource<UserModel>> {
        Log.i("asfsaf", "get user called")
        return user
    }


    fun doNothing(){

    }

    private fun loadUser(it: MutableLiveData<Resource<UserModel>>) {
        Log.i("asfsaf", "CALLED")
        this.viewModelScope.launch {
            it.value = Resource.Loading()
            val userModel = userRepository.getUserData()
            userModel.data!!.userName = userModel.data.firstName + userModel.data.lastName + userModel.data.email
            Log.i("asfsaf", userModel.data.userName.toString())
            it.value=userModel
        }
    }

}