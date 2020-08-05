package com.rove.androidinternshipproject.Extensions

import android.app.Activity
import android.content.Context
import android.widget.Toast

/*Created by Talha Siddiqui on 05/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


fun String.removeLastCharacter() : String{
    val newString=this.substring(0,this.length-1)
    return newString
}

fun String.showToast(context: Context){
    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}
fun Activity.myCustomMethod(){

}