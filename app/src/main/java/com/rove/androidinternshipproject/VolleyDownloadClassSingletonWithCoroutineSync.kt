package com.rove.androidinternshipproject

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import com.rove.androidinternshipproject.Day_Six_Stuff.GeneralStatusWrapperClass
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/*Created by Talha Siddiqui on 10/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


object VolleyDownloadClassSingletonWithCoroutineSync {

    private var queue: RequestQueue? = null

    fun initiliaseMyVolleyDownloadClass(context: Context) {
        queue = Volley.newRequestQueue(context)
    }

    suspend fun doVolleyGetRequest(url: String): String? =
        suspendCancellableCoroutine { coroutine ->
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String?> {
                    //Log.i("res11456",it.toString())
                    coroutine.resume(it)
                    if(it==null) {
                        coroutine.resume(it)
                    }
                    else{
                        kotlin.runCatching {
                            coroutine.resumeWithException(VolleyError())
                        }
                    }

                }, Response.ErrorListener {
                   // Log.i("res11456",it)
                    coroutine.resumeWithException(it)
                })
            stringRequest.setShouldCache(false)
            queue?.add(stringRequest)
        }

    /*fun doVolleyPostRequest(
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
    }*/




}