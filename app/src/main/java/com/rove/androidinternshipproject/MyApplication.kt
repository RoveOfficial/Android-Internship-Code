package com.rove.androidinternshipproject

import android.app.Application
import androidx.room.Room
import com.rove.androidinternshipproject.MVVM.VolleyDownloadClassSingletonSync
import com.rove.androidinternshipproject.RoomDatabase.MainDatabase

/*Created by Talha Siddiqui on 13/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class MyApplication : Application() {

    companion object{
        lateinit var db:MainDatabase
    }

    override fun onCreate() {
        super.onCreate()
        VolleyDownloadClassSingleton.initiliaseMyVolleyDownloadClass(this)
        //VolleyDownloadClassSingletonWithCoroutineSync.initiliaseMyVolleyDownloadClass(this)
        VolleyDownloadClassSingletonSync.initiliaseMyVolleyDownloadClass(this)

        db = Room.databaseBuilder(
            applicationContext,
            MainDatabase::class.java, "MyRoomDatabase"
        ).build()

    }
}