package com.wuhao028.pokedex.ui

import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import com.wuhao028.pokedex.Constants
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.adapter.MoveAdapter
import com.wuhao028.pokedex.adapter.MoveFragmentAdapter
import com.wuhao028.pokedex.util.getTextColor
import com.wuhao028.pokedex.util.getTypeImageRes
import com.wuhao028.pokedex.util.getTypeText
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.ArrayList

/**
 *Created by WuHao028 on 2/11/18
 */

class DetailActivity : AppCompatActivity() {

    private var id: Int = 0
    private var isOk = true
    private var mTabLayout : TabLayout?= null
    private var mViewPager : ViewPager?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getSupportActionBar()?.hide()
        setContentView(R.layout.activity_detail)

        id = getIntent().getIntExtra(Constants.POKEMON_ID, 0)
        var pokemon = DataManager.instance.getPokemonData().get(id)
        var realId = id + 1
        pokename.setText("#"+realId+"  "+pokemon.ename)
        pokeimage.setImageResource(DataManager.instance.getMipmapID("hd" + pokemon.ename))

        var baseObject = pokemon.base
        poke_atk_value.setText(baseObject.get(Constants.ATTACK).toString())
        poke_def_value.setText(baseObject.get(Constants.DEFENSE).toString())
        poke_hp_value.setText(baseObject.get(Constants.HP).toString())
        poke_spatk_value.setText(baseObject.get(Constants.SPATK).toString())
        poke_spdef_value.setText(baseObject.get(Constants.SPDEF).toString())
        poke_speed_value.setText(baseObject.get(Constants.SPEED).toString())

        val typeArray = pokemon.type
        if(typeArray.size() == 1){
            poke_type_image_one.setImageResource(getTypeImageRes(typeArray[0].toString()))
            poke_type_word_one.setText(getTypeText(typeArray[0].toString().replace(" ","")).toUpperCase())
            type_and_image_two_view.visibility = GONE
        }else if(typeArray.size() == 2){
            poke_type_image_one.setImageResource(getTypeImageRes(typeArray[0].toString()))
            poke_type_image_two.setImageResource(getTypeImageRes(typeArray[1].toString()))
            poke_type_word_one.setText(getTypeText(typeArray[0].toString().replace(" ","")).toUpperCase())
            poke_type_word_two.setText(getTypeText(typeArray[1].toString().replace(" ","")).toUpperCase())
            type_and_image_two_view.visibility = VISIBLE
        }

        jp_name.setText(pokemon.jname)
        cn_name.setText(pokemon.cname)
        base_stats_title.setTextColor(Color.parseColor(getTextColor(typeArray[0].toString())))
        base_move.setTextColor(Color.parseColor(getTextColor(typeArray[0].toString())))


        val titles = arrayListOf("egg","tutor","level_up","tm","transfer")
        mViewPager = findViewById(R.id.viewpager) as ViewPager
        mTabLayout = findViewById(R.id.tabs) as TabLayout


        for (i in titles.indices) {
            mTabLayout!!.addTab(mTabLayout!!.newTab().setText(titles[i]))
        }

        val fragments = ArrayList<Fragment>()

        /**
         * 循环遍历添加ViewPager的Fragment
         */
        for (i in titles.indices) {
            val listFragment = MoveFragment()
            val bundle = Bundle()
            val sb = StringBuffer()
            for (j in 1..8) {
                sb.append(titles[i]).append(" ")
            }
            bundle.putString("content", sb.toString())
            listFragment.arguments = bundle
            fragments.add(listFragment)
        }

        val mFragmentAdapteradapter = MoveFragmentAdapter(supportFragmentManager, fragments, titles)
        mViewPager!!.adapter = mFragmentAdapteradapter
        mViewPager!!.adapter = mFragmentAdapteradapter
        mTabLayout!!.setupWithViewPager(mViewPager)
        mTabLayout!!.setTabsFromPagerAdapter(mFragmentAdapteradapter)

        mViewPager!!.setPageTransformer(true, MoveTransformer())

        mTabLayout!!.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                /**
                 * 控制变量
                 */
                if (isOk) {
                    isOk = false
                    val currentItemIndex = mViewPager!!.currentItem

                    if (Math.abs(currentItemIndex - tab!!.position) > 1) {
                        /**
                         * 向后点击
                         */
                        if (currentItemIndex <= tab!!.position) {
                            mViewPager!!.setCurrentItem(tab.position - 1, false)
                            mViewPager!!.setCurrentItem(tab.position, true)
                        }
                        /**
                         * 向前点击
                         */
                        else {
                            mViewPager!!.setCurrentItem(tab.position + 1, false)
                            mViewPager!!.setCurrentItem(tab.position, true)
                        }
                    } else {
                        mViewPager!!.setCurrentItem(tab.position, true)
                    }

                    isOk = true
                }
            }
        })
    }
}