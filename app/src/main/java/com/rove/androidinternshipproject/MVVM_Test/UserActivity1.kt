package com.rove.androidinternshipproject.MVVM_Test

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import com.rove.androidinternshipproject.MyGeneralBAseClassForActivity
import com.rove.androidinternshipproject.R
import kotlinx.android.synthetic.main.activity_user1.*

class UserActivity1 : MyGeneralBAseClassForActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user1)
        rootLayout.post {
            addCommonViews(rootLayout, this)
            initUI()
        }
    }

    private fun initUI() {
        val userModel1: UserViewModel1 by viewModels { DependencyInjectorUtill.getUserViewModelFactory() }
        userModel1.getUsers().observe(this, Observer {
            when (it) {
                is Resource.Success -> {
                    //hideLoadingView()
                    hiTextView.text = "Hi, " + it.data!!.firstName
                    userNameTextView.text = "Your username is\n" + it.data!!.username
                }
                is Resource.Loading -> {
                   // showLoadingView()
                }
                is Resource.Error -> {
                    showCustomError(it.message!!)
                }
            }

        })
    }
}