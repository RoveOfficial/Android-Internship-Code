package com.rove.androidinternshipproject

import android.app.Application

/*Created by Talha Siddiqui on 13/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        VolleyDownloadClassSingleton.initiliaseMyVolleyDownloadClass(this)
    }
}