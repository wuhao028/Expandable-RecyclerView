package com.wuhao028.pokedex.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout

/**
 *Created by WuHao028 on 2/01/19
 */

class InterceptScrollContainer : LinearLayout {

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context) : super(context) {}

    /**
     * 拦截TouchEvent
     * @see android.view.ViewGroup.onInterceptTouchEvent(android.view.MotionEvent)
     */
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return true
    }

    companion object {
        private val TAG = InterceptScrollContainer::class.java.name
    }
}