package com.rove.androidinternshipproject.MVVM

import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import kotlinx.coroutines.delay

/*Created by Talha Siddiqui on 17/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class FakeUserRepository:UserRepositoryInterface {

    override suspend fun getUserData(): Resource<UserModel> {
        delay(3000)
       return Resource.Success<UserModel>(UserModel("hamza","ali",20,"123@gmail.com"))
    }


}