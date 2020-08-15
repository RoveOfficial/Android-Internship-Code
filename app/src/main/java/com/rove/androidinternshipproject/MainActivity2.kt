package com.rove.androidinternshipproject

import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.rove.androidinternshipproject.Day_Six_Stuff.GeneralStatusWrapperClass

class MainActivity2 : MyGeneralBAseClassForActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        getDataFromServer()

    }

    private fun getDataFromServer() {
        VolleyDownloadClassSingleton.doVolleyGetRequest("asdgfasgf")

        VolleyDownloadClassSingleton.myNetowrkDataStatus.observe(this, Observer {
            if (it.status == GeneralStatusWrapperClass.Status.LOADING) {
                showLoadingView()
            } else if (it.status == GeneralStatusWrapperClass.Status.SUCCESS) {
                hideLoadingView()
                //shwo success update UI
            } else {
                hideLoadingView()
                //show error
            }
        })

    }


}