package com.rove.androidinternshipproject.RoomTest

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/*Created by Talha Siddiqui on 19/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUser(): User?


    @Insert
    fun insertUser(user: User)

    @Delete
    fun delete(user: User)

}