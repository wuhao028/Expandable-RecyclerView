package com.wuhao028.pokedex.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.AbsListView
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.adapter.TypeAttackAdapter
import com.wuhao028.pokedex.model.TypeAttack
import java.util.ArrayList

/**
 *Created by WuHao028 on 2/01/19
 */

class TypeAttackActivity : Activity() {

    //头部吸顶视图
    internal lateinit var mHeadStickyView: View
    //头部吸顶的右侧滑动视图
    internal lateinit var mHeadStickyHSView: SyncHScrollView
    //列表的头部视图
    internal lateinit var mHeadHeaderView: View
    //列表的头部视图的右侧滑动视图
    internal lateinit var mHeadHeaderHSView: SyncHScrollView
    //列表视图
    internal lateinit var mListView: ListView
    //数据适配器
    internal lateinit var type4Adapter: TypeAttackAdapter

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_attack)

        //列表的头部视图
        mHeadHeaderView = View.inflate(this, R.layout.type_attack_item_header, null)
        mHeadHeaderHSView = mHeadHeaderView.findViewById(R.id.horizontalScrollView1)
        mHeadHeaderView.isClickable = true

        //头部吸顶视图
        mHeadStickyView = findViewById(R.id.head)
        mHeadStickyHSView = findViewById(R.id.horizontalScrollView1)
        mHeadStickyHSView.AddOnScrollChangedListener(TypeAttackAdapter.OnScrollChangedListenerImp(mHeadHeaderHSView))

        //TODO 划重点：这里需要从传入的列表头拿到里面的右侧滑动控件
        mHeadHeaderView.setOnTouchListener(ListViewAndHeadViewTouchListener())

        mListView = findViewById(R.id.lv_produce)
        mListView.addHeaderView(mHeadHeaderView)
        mListView.setOnTouchListener(ListViewAndHeadViewTouchListener())

        // 创建当前用于显示视图的数据
        val currentData = DataManager.instance.getTypeAttackData()

        type4Adapter = TypeAttackAdapter(this, R.layout.type_attack_item, currentData, mHeadHeaderHSView)
        mListView.adapter = type4Adapter
        // OnClick监听
//        mListView.onItemClickListener = AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 ->
//            Log.i("Type4Activity ListView", "onItemClick Event")
//            Toast.makeText(this@TypeAttackActivity, "点了第" + arg2 + "个",
//                    Toast.LENGTH_SHORT).show()
//        }


        mListView.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (firstVisibleItem >= 1) {
                    mHeadStickyView.visibility = View.VISIBLE
                } else {
                    mHeadStickyView.visibility = View.GONE
                }
            }

            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

            }
        })
    }

    /**
     * TODO 划重点：用来将头部和列表上面的触摸事件都分发给头部的滑动控件
     */
    internal inner class ListViewAndHeadViewTouchListener : View.OnTouchListener {

        override fun onTouch(arg0: View, arg1: MotionEvent): Boolean {
            // 当在列头 和 listView控件上touch时，将这个touch的事件分发给 ScrollView
            mHeadHeaderHSView.onTouchEvent(arg1)
            mHeadStickyHSView.onTouchEvent(arg1)
            return false
        }
    }

}