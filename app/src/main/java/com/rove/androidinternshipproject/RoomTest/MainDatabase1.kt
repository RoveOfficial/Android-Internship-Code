package com.rove.androidinternshipproject.RoomTest

import androidx.room.Database
import androidx.room.RoomDatabase

/*Created by Talha Siddiqui on 19/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


@Database(entities = arrayOf(User::class), version = 1)
abstract class MainDatabase1 : RoomDatabase() {
    abstract fun userDao(): UserDao
}
