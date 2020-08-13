package com.rove.androidinternshipproject.Day_Four_Stuff

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rove.androidinternshipproject.BlurView
import com.rove.androidinternshipproject.R
import kotlinx.android.synthetic.main.rove_slide_up_view.view.*

/*Created by Talha Siddiqui on 12/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class RoveSlideUpView(context: Context,val percentageHeight:Int?=null,val childView:View,var blurView: BlurView?=null) : CardView(context) {

    private var sizeLoaded: MutableLiveData<Boolean> = MutableLiveData();
    private var parentHeight: Int = 0
    private var animation: ObjectAnimator? = null
    private var moveDownOffset = 0f
    private var moveUpOffset = 0f
    private lateinit var mainRootView: View
    private var currentlyVisible = false;


    init{
     inflate(context, R.layout.rove_slide_up_view,this)
        innerMainRlSlideView.addView(childView)
        sizeLoaded.value=false
        elevation = 80f
        radius=80f
        setContentPadding(0, 0, 0, 0)
        clipToPadding = true
        clipChildren=true
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        parentHeight = (parent as View).height
        if (percentageHeight != null) {
            setMeasuredDimension(
                (parent as View).width,
                ((parent as View).height * percentageHeight / 100)
            )
            val heightMeasureSpecChild = MeasureSpec.makeMeasureSpec(
                (parentHeight * percentageHeight / 100),
                MeasureSpec.EXACTLY
            );
            rootRlSlideView.measure(widthMeasureSpec, heightMeasureSpecChild)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        parentHeight = (parent as View).height
            this.visibility = View.INVISIBLE
            moveDownOffset = parentHeight.toFloat()
            moveUpOffset = parentHeight.toFloat() - this.height.toFloat()
            mainRootView = this
            mainRootView.y = parentHeight.toFloat()
            if (sizeLoaded.value == false) {
                sizeLoaded.value = true
        }

    }


    fun slideDown(currentYPos: Float?) {
        val startValue = currentYPos ?: mainRootView.y
        animation?.end()
        animation = ObjectAnimator.ofFloat(mainRootView, "Y", startValue, moveDownOffset)
        animation?.duration = 400
        animation?.start()
        animation?.addListener(object : Animator.AnimatorListener {

            override fun onAnimationStart(animation: Animator) {

            }

            override fun onAnimationEnd(animation: Animator) {
                this@RoveSlideUpView.visibility = View.INVISIBLE
                blurView?.visibility = View.INVISIBLE
                currentlyVisible = false
            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        })
    }

    fun slideUp() {
        if (sizeLoaded.value == true) {
            slideUpOnSizeLoad()
        } else {
            sizeLoaded.observe((context as AppCompatActivity), Observer {
                if (it == true) {
                    slideUpOnSizeLoad()
                }
            })
        }
    }

    private fun slideUpOnSizeLoad() {
        if (!currentlyVisible) {
            currentlyVisible = true
           // blurView!!.visibility = View.VISIBLE
            this.y = parentHeight.toFloat()
            this.visibility = View.VISIBLE
            animation = ObjectAnimator.ofFloat(mainRootView, "Y", moveUpOffset)
            animation?.duration = 400
            animation?.start()
        }
    }

}