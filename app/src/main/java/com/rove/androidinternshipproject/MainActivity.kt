package com.rove.androidinternshipproject

import android.os.Bundle
import android.os.Handler
import android.view.View
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
        blurView.visibility= View.INVISIBLE
        val myCustomLoadingView:MyCustomLoadingView= MyCustomLoadingView(this,blurView)
        val myCustomAlertBox:MyCustomAlertBox= MyCustomAlertBox(this,blurView)


       /* Handler().postDelayed({
            myCustomLoadingView.hideLoading()
        },2000)*/
        rootLayout.addView(myCustomAlertBox)
        myCustomAlertBox.showDialog()
        val volleyDownloadClass= VolleyDownloadClass(this)
        volleyDownloadClass.doVolleyGetRequest("any url")
        /*volleyDownloadClass.onSuccess={
            it?.showToast(this)
        }
        volleyDownloadClass.onFailure={
            it?.showToast(this)
            showError()
        }*/

    }




}