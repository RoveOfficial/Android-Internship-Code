package com.rove.androidinternshipproject.MVVM

import com.android.volley.VolleyError
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import java.lang.Error

/*Created by Talha Siddiqui on 17/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/

//Dependency Injection

class UserRepository:UserRepositoryInterface {

    override suspend fun getUserData(): Resource<UserModel> {
        return try{
            val result=VolleyDownloadClassSingletonSync.doVolleyGetRequest("https://www.facebook.com/")
            //result parse
            Resource.Success<UserModel>(UserModel("talha","siddiqui",20,"abc@gmail.com"))
        } catch(volleyException:VolleyError){
            Resource.Error<UserModel>(volleyException.message.toString())

        }
    }



    /* suspend fun getUserData(): Resource<UserModel> {
         return try{
             val result=VolleyDownloadClassSingletonSync.doVolleyGetRequest("https://www.facebook.commm/")
             //result parse
             Resource.Success<UserModel>(UserModel("talha","siddiqui",20,"abc@gmail.com"))
         } catch(volleyException:VolleyError){
             Resource.Error<UserModel>(volleyException.message.toString())
         }
     }*/

}