package com.rove.androidinternshipproject.Day_Four_Stuff

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rove.androidinternshipproject.BlurView
import com.rove.androidinternshipproject.R

/*Created by Talha Siddiqui on 10/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


open class GeneralViewBaseClass(context: Context, val childViewID: Int,  val blurView: BlurView) :
    RelativeLayout(context) {

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
        inflate(context, childViewID, this)
        this.elevation = 85f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
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


    fun showView() {
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

    private fun showLoadedView() {
        blurView.visibility = View.VISIBLE
        this@GeneralViewBaseClass.y = bottomPos
        this@GeneralViewBaseClass.visibility = View.VISIBLE
        animator = ObjectAnimator.ofFloat(this@GeneralViewBaseClass, "Y", centrePos)
        animator?.duration = 1000
        animator?.start()
    }


    fun hideView() {
        animator = ObjectAnimator.ofFloat(this, "Y", bottomPos)
        animator?.duration = 1000
        animator?.start()
        animator?.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                this@GeneralViewBaseClass.visibility = View.INVISIBLE
                blurView.visibility = View.INVISIBLE
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?) {

            }

        })
    }

}