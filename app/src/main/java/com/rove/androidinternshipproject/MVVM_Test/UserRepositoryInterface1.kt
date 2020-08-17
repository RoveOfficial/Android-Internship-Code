package com.rove.androidinternshipproject.MVVM_Test

import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource

/*Created by Talha Siddiqui on 16/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


interface UserRepositoryInterface1{

    suspend fun getUserData(): Resource<UserModel1>

}