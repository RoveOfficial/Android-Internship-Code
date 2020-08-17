package com.rove.androidinternshipproject.MVVM_Test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/*Created by Talha Siddiqui on 16/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


@Suppress("UNCHECKED_CAST")
class UserViewModelFactory1(private val userRepository1: UserRepositoryInterface1) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel1(userRepository1) as T
    }
}