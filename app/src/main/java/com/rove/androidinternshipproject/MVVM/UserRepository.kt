package com.rove.androidinternshipproject.MVVM

import com.android.volley.VolleyError
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import com.rove.androidinternshipproject.MyApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Error

/*Created by Talha Siddiqui on 17/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/

//Dependency Injection

class UserRepository : UserRepositoryInterface {

    override suspend fun getUserData(): Resource<UserModel> {

        return try {
            val result =
                VolleyDownloadClassSingletonSync.doVolleyGetRequest("https://www.facebook.com/")
            //result parse
            storeDataToDataBase(UserModel("talha", "siddiqui", 20, "abc@gmail.com"))
            Resource.Success<UserModel>(UserModel("talha", "siddiqui", 20, "abc@gmail.com"))
        } catch (volleyException: VolleyError) {
            getDataOfflineIfAvailable(volleyException)
            //Resource.Error<UserModel>(volleyException.message.toString())
        }

    }

    private suspend fun storeDataToDataBase(userModel: UserModel) =
        withContext(Dispatchers.IO) {
            MyApplication.db.userModelDao().insert(userModel)
        }

    private suspend fun getDataOfflineIfAvailable(volleyException: VolleyError) =
        withContext(Dispatchers.IO) {
            val user: UserModel? = MyApplication.db.userModelDao().getUser()
            return@withContext if (user == null) {
                Resource.Error<UserModel>(volleyException.message.toString())
            } else {
                Resource.Success<UserModel>(user)
            }
        }


}