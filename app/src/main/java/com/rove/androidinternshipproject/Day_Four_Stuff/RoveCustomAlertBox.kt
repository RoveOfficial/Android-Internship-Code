package com.rove.androidinternshipproject.Day_Four_Stuff

import android.content.Context
import android.view.View
import com.rove.androidinternshipproject.BlurView
import com.rove.androidinternshipproject.R
import com.rove.androidinternshipproject.Day_Four_Stuff.CustomAlertBoxButtonListener
import kotlinx.android.synthetic.main.rove_custom_alert_box_layout.view.*

/*Created by Talha Siddiqui on 22/07/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class RoveCustomAlertBox(context: Context, blurView: BlurView) : GeneralViewBaseClass(context,
    R.layout.rove_custom_alert_box_layout,blurView) {



var customAlertBoxButtonListener:CustomAlertBoxButtonListener?=null


    fun setDialogType(singleButton: Boolean) {
        if (singleButton) {
            ok_button_centre_rl?.visibility = View.VISIBLE
            two_button_layout?.visibility = View.INVISIBLE
            ok_button_centre_rl?.setOnClickListener { customAlertBoxButtonListener?.onCentreButtonClick() }
        } else {
            two_button_layout?.visibility = View.VISIBLE
            ok_button_centre_rl?.visibility = View.INVISIBLE
            cancel_button_left_rl?.setOnClickListener { customAlertBoxButtonListener?.onLeftButtonClick() }
            ok_button_right_rl?.setOnClickListener { customAlertBoxButtonListener?.onRightButtonClick() }
        }
    }

    //Use this method for specifying leftButton text and rightButton text along with the error/info message
    fun setDialogMessage(
        message: String?,
        leftButtonText: String?,
        rightButtonText: String?
    ) {
        cancel_button_left_textview?.text = leftButtonText
        ok_button_right_textview?.text = rightButtonText
        main_dialog_message?.text = message
    }

    //Use this method for specifying centreButton text along with the error/info message
    fun setDialogMessage(message: String?, centreButtonText: String?) {
        ok_button_centre_textview?.text = centreButtonText
        main_dialog_message?.text = message
    }

    //Use this method for default text for the button(s) selected( one button/two button default text) and passing just the error/info message
    fun setDialogMessage(message: String?) {
        main_dialog_message?.text = message
    }

}