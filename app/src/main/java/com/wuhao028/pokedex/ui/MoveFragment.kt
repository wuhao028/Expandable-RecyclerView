package com.wuhao028.pokedex.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.adapter.MoveAdapter

/**
 *Created by WuHao028 on 15/11/18
 */

class MoveFragment : Fragment() {

    var mRecyclerView : RecyclerView?= null
    var mRecyclerViewAdapter : MoveAdapter ?= null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var rootView  = inflater!!.inflate(R.layout.fragment_move, container, false)
        mRecyclerView = rootView.findViewById(R.id.recycler_view) as RecyclerView
        mRecyclerView!!.layoutManager = LinearLayoutManager(mRecyclerView!!.context)
        mRecyclerViewAdapter = MoveAdapter(activity, arguments.getString("content"))
        mRecyclerView!!.adapter = mRecyclerViewAdapter

        return rootView
    }

    override fun onResume() {
        super.onResume()

        mRecyclerViewAdapter!!.notifyDataSetChanged()
    }
}