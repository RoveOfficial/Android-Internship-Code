package com.rove.androidinternshipproject.Day_Six_Stuff

/*Created by Talha Siddiqui on 14/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class GeneralStatusWrapperClass<T> () {

    enum class Status {
        LOADING,
        SUCCESS,
        ERROR,
    }

    var data : T? = null
    var status:Status=Status.LOADING
    var error:String?=null

}