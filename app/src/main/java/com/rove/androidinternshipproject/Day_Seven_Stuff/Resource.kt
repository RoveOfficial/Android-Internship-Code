package com.rove.androidinternshipproject.Day_Seven_Stuff

/*Created by Talha Siddiqui on 15/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}


