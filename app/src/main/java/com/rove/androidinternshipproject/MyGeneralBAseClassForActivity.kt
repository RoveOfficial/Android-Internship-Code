package com.rove.androidinternshipproject

import android.app.Activity
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.rove.androidinternshipproject.Day_Four_Stuff.CustomAlertBoxButtonListener
import com.rove.androidinternshipproject.Day_Four_Stuff.MyCustomLoadingView2
import com.rove.androidinternshipproject.Day_Four_Stuff.RoveCustomAlertBox

/*Created by Talha Siddiqui on 12/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


open class MyGeneralBAseClassForActivity : AppCompatActivity() {


    private var rootLayout: RelativeLayout? = null
    private lateinit var context: Activity
    private var pb: ProgressBar? = null
    lateinit var roveBlurView: BlurView
    private var roveLoadingView: MyCustomLoadingView2? = null
    private var roveAlertBox: RoveCustomAlertBox? = null

    fun addCommonViews(rootRl: RelativeLayout?, context: Activity) {
        this.rootLayout = rootRl
        this.context = context
        addBlurView()
        addAlertBox()
        addProgressBar()
        addLoadingView()
    }

    private fun addAlertBox() {
        roveAlertBox = RoveCustomAlertBox(context, roveBlurView)
        rootLayout!!.addView(roveAlertBox)
    }

    private fun addLoadingView() {
        roveLoadingView = MyCustomLoadingView2(context, roveBlurView)
        rootLayout?.addView(roveLoadingView)
    }

    private fun addBlurView() {
        roveBlurView = BlurView(this)
        rootLayout!!.addView(roveBlurView)
    }


    private fun addProgressBar() {
        pb = ProgressBar(context)
        rootLayout?.addView(pb)
        val layoutParams =
            pb?.layoutParams as RelativeLayout.LayoutParams
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        pb?.layoutParams = layoutParams
        pb?.elevation = 30f
        hideProgressBar()
    }

    fun showProgressBar(blockUI: Boolean) {
        pb?.visibility = View.VISIBLE
        if (blockUI) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        }
    }

    fun hideProgressBar() {
        pb?.visibility = View.INVISIBLE
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }


    fun showLoadingView() {
        roveLoadingView?.showView()
    }

    fun hideLoadingView() {
        roveLoadingView?.hideView()
    }

    fun showNetworkError() {
       // hideLoadingView()
        hideProgressBar()
        roveAlertBox?.setDialogType(true)
        roveAlertBox?.setDialogMessage("A network error just occurred. Please try again in a bit. :(")
        roveAlertBox?.showView()
        roveAlertBox?.customAlertBoxButtonListener = object : CustomAlertBoxButtonListener {
            override fun onLeftButtonClick() {

            }

            override fun onRightButtonClick() {

            }

            override fun onCentreButtonClick() {
                roveAlertBox?.hideView()
            }
        }
    }

    fun showUnknownError() {
        //hideLoadingView()
        hideProgressBar()
        roveAlertBox?.setDialogType(true)
        roveAlertBox?.setDialogMessage("An unknown error just occurred. Please try again in a bit. :(")
        roveAlertBox?.showView()
        roveAlertBox?.customAlertBoxButtonListener = object : CustomAlertBoxButtonListener {
            override fun onLeftButtonClick() {

            }

            override fun onRightButtonClick() {

            }

            override fun onCentreButtonClick() {
                roveAlertBox?.hideView()
            }
        }
    }


    fun showCustomError(customError: String) {
        //hideLoadingView()
        hideProgressBar()
        roveAlertBox?.setDialogType(true)
        roveAlertBox?.setDialogMessage(customError)
        roveAlertBox?.showView()
        roveAlertBox?.customAlertBoxButtonListener = object : CustomAlertBoxButtonListener {
            override fun onLeftButtonClick() {

            }

            override fun onRightButtonClick() {

            }

            override fun onCentreButtonClick() {
                roveAlertBox?.hideView()
            }
        }
    }


    fun showCustomConfirmation(
        message: String?,
        leftButtonText: String?,
        rightButtonText: String?,
        alertBoxButtonListener: CustomAlertBoxButtonListener?
    ) {
        roveAlertBox?.setDialogType(false)
        if (leftButtonText != null && rightButtonText != null) {
            roveAlertBox?.setDialogMessage(message, leftButtonText, rightButtonText)
        } else {
            roveAlertBox?.setDialogMessage(message)
        }
        roveAlertBox?.showView()
        roveAlertBox?.customAlertBoxButtonListener = alertBoxButtonListener
    }


    fun hideDialog() {
        roveAlertBox?.hideView()
    }

}