package com.rove.androidinternshipproject.MVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/*Created by Talha Siddiqui on 17/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


@Suppress("UNCHECKED_CAST")
class UserViewModelFactoryClass(private val userRepository: UserRepositoryInterface) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(userRepository) as T
    }
}