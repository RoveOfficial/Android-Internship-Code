package com.rove.androidinternshipproject

import android.app.Activity
import android.content.Context

/*Created by Talha Siddiqui on 05/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class MyNetworkClass(val context:Context) {
    lateinit var networkDataListener:NetworkDataListener
    lateinit var  onDataReceived : ((data:String)->Unit)


    fun getData() {
        Thread(){
            //LONG RUNNING OPERATION
            Thread.sleep(2000)
            val data:String="Data received from Server successfully"

            (context as Activity).runOnUiThread {
                //networkDataListener.onDataReceived(data)
                onDataReceived.invoke(data)
            }

        }.start()
    }

}