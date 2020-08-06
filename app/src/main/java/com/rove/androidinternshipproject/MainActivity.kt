package com.rove.androidinternshipproject

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.rove.androidinternshipproject.Extensions.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* val myNetworkClass = MyNetworkClass(this)
         myNetworkClass.getData()
         myNetworkClass.onDataReceived = ::showData*/
        val blurView: BlurView = BlurView(this)
        rootLayout.addView(blurView)
        val myCustomLoadingView:MyCustomLoadingView= MyCustomLoadingView(this)
      /*  Handler().postDelayed(Runnable {
            myCustomLoadingView.showLoading()
        },1000)*/
        myCustomLoadingView.showLoading()
        rootLayout.addView(myCustomLoadingView)
        // "Hello World".showToast(this)
        //myCustomMethod()
    }

    /* fun showData(data:String){
         data.showToast(this)
     }*/


}