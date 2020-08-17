package com.rove.androidinternshipproject.MVVM

import android.app.Activity
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import com.rove.androidinternshipproject.Day_Six_Stuff.GeneralStatusWrapperClass
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/*Created by Talha Siddiqui on 10/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


object VolleyDownloadClassSingletonSync {

    private var queue: RequestQueue? = null
    private var volleyRequestTag: String? = null

    fun initiliaseMyVolleyDownloadClass(context: Context) {
        queue = Volley.newRequestQueue(context)
        volleyRequestTag = context.javaClass.simpleName
    }

    suspend fun doVolleyGetRequest(url: String): String? =
        suspendCancellableCoroutine { coroutine ->
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String?> {
                    if (it == null) {
                        kotlin.runCatching {
                            coroutine.resumeWithException(VolleyError("An unknown error occurred"))
                        }
                    } else {
                        coroutine.resume(it)
                    }

                }, Response.ErrorListener {
                    coroutine.resumeWithException(it)
                })
            stringRequest.setShouldCache(false)
            stringRequest.tag = volleyRequestTag
            queue?.add(stringRequest)
        }

}