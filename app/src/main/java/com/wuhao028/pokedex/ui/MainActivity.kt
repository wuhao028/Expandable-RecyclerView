package com.wuhao028.pokedex.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.model.TabEntity
import kotlinx.android.synthetic.main.main_view.*
import java.util.*

/**
 *Created by WuHao028 on 12/11/18
 */

class MainActivity : AppCompatActivity() {

    private val mTitles = arrayOf("Pokedex", "News", "Tool", "Mine")

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected)

    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mHomeFragment: PokedexFragment? = null
    private var mNewsFragment: NewsFragment? = null
    private var mHotFragment: ToolFragment? = null
    private var mMineFragment: MineFragment? = null
    //默认为0
    private var mIndex = 0
    private var mFragmentId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)
        this.getSupportActionBar()?.hide()
        setContentView(R.layout.main_view)
        mFragmentId = R.id.fl_container
        initTab()
        tab_layout.currentTab = mIndex
        switchFragment(mIndex)
        Log.d("MainActivity", "onCreate")

    }

    //初始化底部菜单
    private fun initTab() {
        (0 until mTitles.size)
                .mapTo(mTabEntities) { TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it]) }
        //为Tab赋值
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                //切换Fragment
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {

            }
        })
    }

    /**
     * 切换Fragment
     * @param position 下标
     */
    private fun switchFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (position) {
            0 // 首页
            -> mHomeFragment?.let {
                transaction.show(it)
            } ?: PokedexFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(mFragmentId, it, "home")
            }
            1  //新闻
            -> mNewsFragment?.let {
                transaction.show(it)
            } ?: NewsFragment.getInstance(mTitles[position]).let {
                mNewsFragment = it
                transaction.add(mFragmentId, it, "discovery")
            }
            2  //热门
            -> mHotFragment?.let {
                transaction.show(it)
            } ?: ToolFragment.getInstance(mTitles[position]).let {
                mHotFragment = it
                transaction.add(mFragmentId, it, "hot")
            }
            3 //我的
            -> mMineFragment?.let {
                transaction.show(it)
            } ?: MineFragment.getInstance(mTitles[position]).let {
                mMineFragment = it
                transaction.add(mFragmentId, it, "mine")
            }

            else -> {

            }
        }

        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()
    }

    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it as Fragment) }
        mNewsFragment?.let { transaction.hide(it as Fragment) }
        mHotFragment?.let { transaction.hide(it as Fragment) }
        mMineFragment?.let { transaction.hide(it as Fragment) }
    }

}
