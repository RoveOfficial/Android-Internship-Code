package com.rove.androidinternshipproject

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*Created by Talha Siddiqui on 06/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


class MyCustomLoadingView(context: Context) : RelativeLayout(context) {
    var bottomPos = 0f
    var centrePos = 0f
    var animator:ObjectAnimator?=null
    var sizeLoaded=false

    init {
        initialiseView()
    }

    private fun initialiseView() {
        View.inflate(context, R.layout.my_loading_view_layout, this)
        this.elevation = 85f
        this.visibility= View.INVISIBLE
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val parentHeight = (this.parent as View).height
        bottomPos = parentHeight.toFloat()
        centrePos = (parentHeight / 2).toFloat() - (this.height/2)
        this.y = bottomPos
        this.visibility= View.INVISIBLE
        sizeLoaded=true
    }

    fun showLoading(){
        (context as AppCompatActivity).lifecycleScope.launch {
           waitForViewToGetLoaded()
            showLoadedView()
        }

    }

    private suspend fun waitForViewToGetLoaded(){
        withContext(Dispatchers.IO) {
            while(!sizeLoaded){
            //wait for size load
        }
        }
    }

    private suspend fun showLoadedView(){
        this@MyCustomLoadingView.y = bottomPos
        this@MyCustomLoadingView.visibility = View.VISIBLE
        animator = ObjectAnimator.ofFloat(this@MyCustomLoadingView, "Y", centrePos)
        animator?.duration = 1000
        animator?.start()
    }



    fun hideLoading(){
        animator = ObjectAnimator.ofFloat(this, "Y", bottomPos)
        animator?.duration = 1000
        animator?.start()
        animator?.addListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                this@MyCustomLoadingView.visibility = View.INVISIBLE
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?) {

            }

        })
    }

}