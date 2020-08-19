/*
package com.rove.androidinternshipproject.MVVM

import android.util.Log
import com.android.volley.VolleyError
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import com.rove.androidinternshipproject.MyApplication
import com.rove.androidinternshipproject.RoomTest.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

*/
/*Created by Talha Siddiqui on 17/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*//*


//Dependency Injection

class UserRepositoryTest:UserRepositoryInterfaceTest {

    override suspend fun getUserData(): Resource<User> {
        return try{
            val result=VolleyDownloadClassSingletonSync.doVolleyGetRequest("https://www.facebook.comm/")
            //result parse
            Resource.Success<User>(User("talha","siddiqui",20,"abc@gmail.com"))
        } catch(volleyException:VolleyError){
            checkForOfflineData(volleyException)
           // Resource.Error<User>(volleyException.message.toString())
        }
    }

    private suspend fun checkForOfflineData(volleyException: VolleyError) =
        withContext(Dispatchers.IO){
            val user=MyApplication.db.userDao().getUser()
            if(user==null){
                Log.i("ASfsaf","null")
                Resource.Error<User>(volleyException.message.toString())
            }
            else{
                Log.i("ASfsaf","not null")
                return@withContext Resource.Success<User>(user)
            }
        }



    */
/* suspend fun getUserData(): Resource<UserModel> {
         return try{
             val result=VolleyDownloadClassSingletonSync.doVolleyGetRequest("https://www.facebook.commm/")
             //result parse
             Resource.Success<UserModel>(UserModel("talha","siddiqui",20,"abc@gmail.com"))
         } catch(volleyException:VolleyError){
             Resource.Error<UserModel>(volleyException.message.toString())
         }
     }*//*


}*/
