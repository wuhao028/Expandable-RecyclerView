package com.wuhao028.pokedex

import android.content.Context
import android.view.View
import android.widget.Toast

/**
 *Created by WuHao028 on 2/11/18
 */

fun View.dip2px(dipValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (dipValue * scale + 0.5f).toInt()
}


fun View.px2dip(pxValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

fun String.filterAlph(): String {
    var regex = Regex("[^(A-Za-z)]")
    return this?.replace(regex, "").toLowerCase()
}

fun Context.showToast(content: String): Toast {
    val toast = Toast.makeText(PokeApplication.context, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}