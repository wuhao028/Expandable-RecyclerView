package com.wuhao028.pokedex.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.model.PokeTool
import com.wuhao028.pokedex.ui.ItemActivity
import com.wuhao028.pokedex.ui.TypeAttackActivity
import kotlinx.android.synthetic.main.tool_item.view.*

/**
 *Created by WuHao028 on 1/01/19
 */

class ToolsAdapter(val items: ArrayList<PokeTool>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


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
        nameView?.text = items.get(position).name
        imageView?.setImageResource(items.get(position).imageRes)

        view.setOnClickListener {
            when (position) {
                0 -> {
                    val intent = Intent(context, TypeAttackActivity::class.java)
                    context.startActivity(intent)
                }
                1 -> {
                    val intent = Intent(context, ItemActivity::class.java)
                    context.startActivity(intent)
                }
            }

        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tool_item = view.poke_tool_item_text
    }

}

