package com.wuhao028.pokedex.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.adapter.ToolsAdapter
import com.wuhao028.pokedex.model.PokeTool
import kotlinx.android.synthetic.main.fragment_tool.*

/**
 *Created by WuHao028 on 3/01/19
 */

class MineFragment : Fragment() {

    private var mTitle: String? = null
    val tools: ArrayList<PokeTool> = ArrayList()

    companion object {
        fun getInstance(title: String): MineFragment {
            val fragment = MineFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    fun initData(){
        tools.add(PokeTool("Feedback", R.mipmap.item_dragon_scale))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tool, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        poke_tool_recyclerview.layoutManager = LinearLayoutManager(this.context)
        poke_tool_recyclerview.adapter = ToolsAdapter(tools,this.context)
        poke_tool_recyclerview.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
    }
}