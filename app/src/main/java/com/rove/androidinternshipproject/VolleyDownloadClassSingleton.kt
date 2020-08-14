package com.rove.androidinternshipproject

import android.app.Activity
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.rove.androidinternshipproject.Day_Six_Stuff.GeneralStatusWrapperClass

/*Created by Talha Siddiqui on 10/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


object VolleyDownloadClassSingleton {

    private var queue: RequestQueue? = null
    private var volleyRequestTag: String? = null
    var onSuccess: ((data: String?) -> Unit)? = null
    var onFailure: ((error: String?) -> Unit)? = null
    val myNetowrkDataStatus=MutableLiveData<GeneralStatusWrapperClass<String>>()
    val myGeneralStatusWrapperClass=GeneralStatusWrapperClass<String>()

    fun initiliaseMyVolleyDownloadClass(context:Context){
        queue = Volley.newRequestQueue(context)
        volleyRequestTag = context.javaClass.simpleName
        myNetowrkDataStatus.value=myGeneralStatusWrapperClass
    }

    fun doVolleyGetRequest(url: String) {
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String?> {
                onSuccess?.invoke(it)
                myGeneralStatusWrapperClass.status=GeneralStatusWrapperClass.Status.SUCCESS
                myNetowrkDataStatus.value=myGeneralStatusWrapperClass

            }, Response.ErrorListener {
                onFailure?.invoke(it.message)
                myGeneralStatusWrapperClass.status=GeneralStatusWrapperClass.Status.ERROR
                myNetowrkDataStatus.value=myGeneralStatusWrapperClass
            })
        stringRequest.setShouldCache(false)
        stringRequest.tag = volleyRequestTag
        queue?.add(stringRequest)
    }

    fun doVolleyPostRequest(
        url: String,
        params: MutableMap<String, String>
    ) {
        val stringRequest: StringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener<String?> { }, Response.ErrorListener {
                //volleyListener.onError(error.getMessage())
            }) {
            override fun getParams(): MutableMap<String, String> {
                return params
            }
        }
        stringRequest.setShouldCache(false)
        stringRequest.tag = volleyRequestTag
        queue?.add(stringRequest)
    }

    fun cancelAllRequests() {
        queue?.cancelAll(volleyRequestTag)
    }


}