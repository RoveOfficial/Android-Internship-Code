package com.rove.androidinternshipproject.MVVM_Test

/*Created by Talha Siddiqui on 16/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


object DependencyInjectorUtill {

fun getUserViewModelFactory():UserViewModelFactory1{
    return UserViewModelFactory1(UserRepository11())
}

}