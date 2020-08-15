package com.rove.androidinternshipproject.Day_Seven_Stuff

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rove.androidinternshipproject.MyGeneralBAseClassForActivity
import com.rove.androidinternshipproject.R
import kotlinx.android.synthetic.main.activity_main.rootLayout

class TempActivity : MyGeneralBAseClassForActivity() {
    val userData= MutableLiveData<Resource<String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)
        addCommonViews(rootLayout,this)
        fetchUserData()
        userData.observe(this, Observer {
           when(it){
               is Resource.Success -> {
                   hideLoadingView()
                   showCustomError(it.data!!)
               }
               is Resource.Loading -> {
                   showLoadingView()
               }
               is Resource.Error -> {

               }
           }
        })
        //val viewModel by viewModels<MyViewModel>()

    }

    private fun fetchUserData() {
        Thread{
             postData{userData.value=Resource.Loading() }
            Thread.sleep(5000)
            postData {userData.value=Resource.Success("abc")}
        }.start()
    }

    private fun postData(mycustomFunc:()->Unit){
        runOnUiThread {
            mycustomFunc.invoke()
        }
    }

}


