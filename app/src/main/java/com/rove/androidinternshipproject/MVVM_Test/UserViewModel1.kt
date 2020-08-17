package com.rove.androidinternshipproject.MVVM_Test

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import kotlinx.coroutines.launch

/*Created by Talha Siddiqui on 16/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class UserViewModel1(private val userRepository1: UserRepositoryInterface1) : ViewModel() {

    private val user1: MutableLiveData<Resource<UserModel1>> by lazy {
        MutableLiveData<Resource<UserModel1>>().also {
            loadUser()
        }
    }

    fun getUsers(): LiveData<Resource<UserModel1>> {
        return user1
    }

    private fun loadUser() {
        this.viewModelScope.launch {
            user1.value=Resource.Loading()
            Log.i("res11456","Getting data")
            val userModel=userRepository1.getUserData()
            userModel.data?.username=userModel.data?.firstName+userModel.data?.lastName+userModel.data?.email
            user1.value=userModel
        }
    }


}