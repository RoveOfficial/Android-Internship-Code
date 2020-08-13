package com.rove.androidinternshipproject

import android.os.Bundle
import android.view.View
import com.rove.androidinternshipproject.Day_Four_Stuff.RoveSlideUpView

import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : MyGeneralBAseClassForActivity() {
    lateinit var volleyDownloadClass:VolleyDownloadClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addCommonViews(rootLayout, this)
       // showCustomError("An error occurred")

         val myDateView:View=View.inflate(this,R.layout.date_picker_view,null)
         val roveSlideUpView= RoveSlideUpView(this,50,myDateView)
         rootLayout.addView(roveSlideUpView)
         roveSlideUpView.slideUp()
        val name="Jhon"
        val age="15"
        val gender="male"

        UserData.name=name
        UserData.name=age
        UserData.name=gender


        //rootLayout.addView(myCustomAlertBox)
        //myCustomAlertBox.showDialog()
        volleyDownloadClass = VolleyDownloadClass(this)
         volleyDownloadClass.doVolleyGetRequest("any url")
         val weakThis = WeakReference(this)
         volleyDownloadClass.onSuccess= { weakThis.get()?.onResult() } // no capture, no leak!


        /* volleyDownloadClass.onSuccess={
          onResult()
         }
         volleyDownloadClass.onFailure={

         }*/


        //Value Types
        var a:String="aaa"
        var b:String=a
        b="123"

        //Reference Types
        var myList1=ArrayList<String>()
        myList1.add("abc")
        var myList2=myList1
        myList2[0]="123"

    }

    override fun onDestroy() {
        volleyDownloadClass.onSuccess=null
        volleyDownloadClass.onFailure=null
        super.onDestroy()
    }

    private fun onResult() {

    }


}