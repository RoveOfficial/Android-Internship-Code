package com.rove.androidinternshipproject

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        getDataFromServer()
    }

    private fun getDataFromServer() {
        VolleyDownloadClassSingleton.doVolleyGetRequest("asdgfasgf")
        VolleyDownloadClassSingleton.onSuccess={

        }
        VolleyDownloadClassSingleton.onFailure={
        }

        startAsyncWork()

    }


    private fun startAsyncWork() {
        val work = Runnable { SystemClock.sleep(20000) }
        Thread(work).start()
    }

    override fun onDestroy() {
        super.onDestroy()
        VolleyDownloadClassSingleton.onSuccess=null
        VolleyDownloadClassSingleton.onFailure=null
    }
}