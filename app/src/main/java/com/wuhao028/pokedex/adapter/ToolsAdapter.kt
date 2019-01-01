package com.wuhao028.pokedex.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.wuhao028.pokedex.R
import kotlinx.android.synthetic.main.tool_item.view.*
import java.time.Duration

/**
 *Created by WuHao028 on 1/01/19
 */

class ToolsAdapter(val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.tool_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val view = holder!!.itemView
        val nameView = view.findViewById<TextView>(R.id.poke_tool_item_text)
        val imageView = view.findViewById<ImageView>(R.id.poke_tool_item_image)
        nameView?.text = items.get(position)
        imageView?.setImageResource(R.mipmap.abra)

        view.setOnClickListener {

        }
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tool_item = view.poke_tool_item_text
    }

}

