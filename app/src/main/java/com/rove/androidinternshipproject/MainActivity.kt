package com.rove.androidinternshipproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rove.androidinternshipproject.Extensions.showToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myNetworkClass = MyNetworkClass(this)
        myNetworkClass.getData()
        myNetworkClass.onDataReceived = ::showData
        // "Hello World".showToast(this)
        //myCustomMethod()
    }

    fun showData(data:String){
        data.showToast(this)
    }

    
}