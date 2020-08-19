package com.rove.androidinternshipproject.RoomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rove.androidinternshipproject.MVVM.UserModel
import com.rove.androidinternshipproject.RoomTest.UserDao

/*Created by Talha Siddiqui on 19/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


@Database(entities = arrayOf(UserModel::class), version = 1)
abstract class MainDatabase : RoomDatabase() {
    abstract fun userModelDao(): UserModelDao
}
