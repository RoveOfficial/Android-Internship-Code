package com.rove.androidinternshipproject

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*Created by Talha Siddiqui on 06/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class MyCustomAlertBox(context: Context, val blurView: BlurView) : RelativeLayout(context) {
    var bottomPos = 0f
    var centrePos = 0f
    var animator: ObjectAnimator? = null

    //var sizeLoaded=false
    val sizeLoaded = MutableLiveData<Boolean>()

    init {
        sizeLoaded.value = false
        initialiseView()
    }

    private fun initialiseView() {
        View.inflate(context, R.layout.alert_box_custom, this)
        this.elevation=80f
        
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val parentHeight = (this.parent as View).height
        bottomPos = parentHeight.toFloat()
        centrePos = (parentHeight / 2).toFloat() - (this.height / 2)
        this.y = bottomPos
        this.visibility = View.INVISIBLE
        sizeLoaded.value = true
    }

    fun showDialog() {
        (context as AppCompatActivity).lifecycleScope.launch {
            if (sizeLoaded.value == true) {
                showLoadedView()
            } else {
                sizeLoaded.observe(context as AppCompatActivity, Observer {
                    if (sizeLoaded.value == true) {
                        showLoadedView()
                    }
                })
            }
        }

    }

    private fun showLoadedView() {
        blurView.visibility=View.VISIBLE
        this@MyCustomAlertBox.y = bottomPos
        this@MyCustomAlertBox.visibility = View.VISIBLE
        animator = ObjectAnimator.ofFloat(this@MyCustomAlertBox, "Y", centrePos)
        animator?.duration = 1000
        animator?.start()
    }


    fun hideDialog() {
        animator = ObjectAnimator.ofFloat(this, "Y", bottomPos)
        animator?.duration = 1000
        animator?.start()
        animator?.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                this@MyCustomAlertBox.visibility = View.INVISIBLE
                blurView.visibility=View.INVISIBLE
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?) {

            }

        })
    }

}