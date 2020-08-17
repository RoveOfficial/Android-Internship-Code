package com.rove.androidinternshipproject.MVVM_Test

import com.android.volley.VolleyError
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import com.rove.androidinternshipproject.VolleyDownloadClassSingletonWithCoroutineSync

/*Created by Talha Siddiqui on 16/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class UserRepository11 : UserRepositoryInterface1 {



    override suspend fun getUserData():  Resource<UserModel1> {
        return try{
            val result=VolleyDownloadClassSingletonWithCoroutineSync.doVolleyGetRequest("https://www.facebook.com/")
            Resource.Success<UserModel1>(UserModel1("talha","siddiqui","15","male","abc@gmail.com"))
        } catch (e:VolleyError){
            Resource.Error<UserModel1>(e.message.toString())
        }
    }


}