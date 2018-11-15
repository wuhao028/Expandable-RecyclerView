package com.wuhao028.pokedex.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 *Created by WuHao028 on 15/11/18
 */

class MoveFragmentAdapter(fm : FragmentManager, val mFragments : List<Fragment>, val mTitles : List<String>) : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {

        return mFragments[position]
    }

    override fun getCount(): Int {

        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles[position]
    }
}