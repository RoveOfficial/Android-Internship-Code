package com.rove.androidinternshipproject.MVVM

import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource

/*Created by Talha Siddiqui on 17/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


interface UserRepositoryInterface {
    suspend fun getUserData(): Resource<UserModel>

}