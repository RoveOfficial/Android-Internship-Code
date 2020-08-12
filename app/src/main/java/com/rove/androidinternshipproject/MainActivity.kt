package com.rove.androidinternshipproject

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rove.androidinternshipproject.Day_Four_Stuff.RoveSlideUpView
import com.rove.androidinternshipproject.Extensions.showToast

import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : MyGeneralBAseClassForActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addCommonViews(rootLayout, this)
        showCustomError("An error occurred")

        /* val myDateView:View=View.inflate(this,R.layout.date_picker_view,null)
         val roveSlideUpView= RoveSlideUpView(this,40,myDateView)
         rootLayout.addView(roveSlideUpView)
         roveSlideUpView.slideUp()*/


        //rootLayout.addView(myCustomAlertBox)
        //myCustomAlertBox.showDialog()
        val volleyDownloadClass = VolleyDownloadClass(this)
        /* volleyDownloadClass.doVolleyGetRequest("any url")
         val weakThis = WeakReference(this)
         volleyDownloadClass.onSuccess= { } // no capture, no leak!

         volleyDownloadClass.onSuccess={
             it?.showToast(this)
         }
         volleyDownloadClass.onFailure={
             it?.showToast(this)
         }*/

    }


    private fun onResult() {

    }


}