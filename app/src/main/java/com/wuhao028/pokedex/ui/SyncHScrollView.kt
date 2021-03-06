package com.wuhao028.pokedex.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.HorizontalScrollView
import java.util.*

/**
 *Created by WuHao028 on 2/01/19
 */

class SyncHScrollView : HorizontalScrollView {
    internal var mScrollViewObserver: ScrollViewObserver? = ScrollViewObserver()

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context) : super(context) {}

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        /*
         * 当滚动条移动后，引发 滚动事件。通知给观察者，观察者会传达给其他的条目中的滚动视图。
		 */
        if (mScrollViewObserver != null) {
            mScrollViewObserver!!.NotifyOnScrollChanged(l, t, oldl, oldt)
        }
        super.onScrollChanged(l, t, oldl, oldt)
    }

    /*
     * 订阅 本控件 的 滚动条变化事件
     * */
    fun AddOnScrollChangedListener(listener: OnScrollChangedListener) {
        mScrollViewObserver!!.AddOnScrollChangedListener(listener)
    }

    /*
     * 取消 订阅 本控件 的 滚动条变化事件
     * */
    fun RemoveOnScrollChangedListener(listener: OnScrollChangedListener) {
        mScrollViewObserver!!.RemoveOnScrollChangedListener(listener)
    }

    /*
     * 当发生了滚动事件时
     */
    interface OnScrollChangedListener {
        fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int)
    }

    /**
     * 观察者
     */
    class ScrollViewObserver {
        internal var mList: MutableList<OnScrollChangedListener>? = null

        init {
            mList = ArrayList()
        }

        fun AddOnScrollChangedListener(listener: OnScrollChangedListener) {
            mList!!.add(listener)
        }

        fun RemoveOnScrollChangedListener(
                listener: OnScrollChangedListener) {
            mList!!.remove(listener)
        }

        fun NotifyOnScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
            if (mList == null || mList!!.size == 0) {
                return
            }
            for (i in mList!!.indices) {
                if (mList!![i] != null) {
                    mList!![i].onScrollChanged(l, t, oldl, oldt)
                }
            }
        }
    }
}