package com.wuhao028.pokedex.model

import com.flyco.tablayout.listener.CustomTabEntity

/**
 *Created by WuHao028 on 12/11/18
 */

class TabEntity(var title: String, private var selectedIcon: Int, private var unSelectedIcon: Int) : CustomTabEntity {

    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }
}