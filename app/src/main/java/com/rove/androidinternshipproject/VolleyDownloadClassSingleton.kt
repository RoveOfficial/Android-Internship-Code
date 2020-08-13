package com.rove.androidinternshipproject

import android.app.Activity
import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

/*Created by Talha Siddiqui on 10/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


object VolleyDownloadClassSingleton {

    private var queue: RequestQueue? = null
    private var volleyRequestTag: String? = null
    var onSuccess: ((data: String?) -> Unit)? = null
    var onFailure: ((error: String?) -> Unit)? = null

    fun initiliaseMyVolleyDownloadClass(context:Context){
        queue = Volley.newRequestQueue(context)
        volleyRequestTag = context.javaClass.simpleName
    }

    fun doVolleyGetRequest(url: String) {
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String?> {
                onSuccess?.invoke(it)

            }, Response.ErrorListener {
                onFailure?.invoke(it.message)
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