package com.wuhao028.pokedex.ui

import android.support.v4.view.ViewPager
import android.view.View
import com.wuhao028.pokedex.R

/**
 *Created by WuHao028 on 15/11/18
 */

class MoveTransformer : ViewPager.PageTransformer {

    /**
     * 回调方法,重写viewpager的切换动画
     */
    override fun transformPage(view: View, position: Float) {
        val pageWidth = view.width
        val wallpaper = view.findViewById<View>(R.id.recycler_view)
        if (position < -1) { // [-Infinity,-1)
            wallpaper.translationX = 0.toFloat()
            view.translationX = 0.toFloat()
        } else if (position <= 1) { // [-1,1]
            wallpaper.translationX = pageWidth * getFactor(position)
            view.translationX = 8 * position
        } else { // (1,+Infinity]
            wallpaper.translationX = 0.toFloat()
            view.translationX = 0.toFloat()
        }
    }

    private fun getFactor(position: Float): Float {
        return -position / 2
    }

}