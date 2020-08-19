package com.rove.androidinternshipproject.RoomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.rove.androidinternshipproject.MVVM.UserModel

/*Created by Talha Siddiqui on 19/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/

//CRUD - Create, Read, Update, Delete

@Dao
interface UserModelDao{

    @Query("SELECT * FROM UserModel")
    fun getUser(): UserModel?

    @Insert
    fun insert(user: UserModel)

    @Delete
    fun delete(user: UserModel)


}