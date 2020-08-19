package com.rove.androidinternshipproject.MVVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.rove.androidinternshipproject.Day_Seven_Stuff.Resource
import com.rove.androidinternshipproject.MyGeneralBAseClassForActivity
import com.rove.androidinternshipproject.R
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : MyGeneralBAseClassForActivity() {

    val userViewModel: UserViewModel by viewModels {
        DependencyInjectorUtility.getUserViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        addCommonViews(root, this)
        Log.i("asfsaf", "ONCREATE CALLED")
        //userViewModel.doNothing()
        userViewModel.getUsers().observe(this, Observer {
            when (it) {
                is Resource.Success -> {
                    hideLoadingView()
                    userGreeting.text = "Hi, " + it.data!!.firstName
                    userName.text = "Your username is\n" + it.data!!.userName
                }
                is Resource.Loading -> {
                    showLoadingView()
                }
                is Resource.Error -> {
                    hideLoadingView()
                    showCustomError(it.message!!)
                }
            }
        })
    }
}
