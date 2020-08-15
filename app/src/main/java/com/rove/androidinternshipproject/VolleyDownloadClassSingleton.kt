package com.rove.androidinternshipproject

import android.app.Activity
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import com.rove.androidinternshipproject.Day_Six_Stuff.GeneralStatusWrapperClass

/*Created by Talha Siddiqui on 10/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


object VolleyDownloadClassSingleton {

    private var queue: RequestQueue? = null
    private var volleyRequestTag: String? = null
    var onSuccess: ((data: String?) -> Unit)? = null
    var onFailure: ((error: String?) -> Unit)? = null
    var myNetowrkDataStatus = MutableLiveData<Resource<String>>()

    fun initiliaseMyVolleyDownloadClass(context: Context) {
        queue = Volley.newRequestQueue(context)
        volleyRequestTag = context.javaClass.simpleName
    }

    fun doVolleyGetRequest(url: String) {
        myNetowrkDataStatus.value = Resource.Loading<String>()
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String?> {
               // onSuccess?.invoke(it)
                myNetowrkDataStatus.value=Resource.Success(it.toString())

            }, Response.ErrorListener {
                onFailure?.invoke(it.message)
                myNetowrkDataStatus.value=Resource.Error(it.message.toString())
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