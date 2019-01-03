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
import com.wuhao028.pokedex.model.PokeItem
import com.wuhao028.pokedex.ui.TypeAttackActivity
import kotlinx.android.synthetic.main.item_poke_item.view.*
import kotlinx.android.synthetic.main.tool_item.view.*

/**
 *Created by WuHao028 on 3/01/19
 */


class ItemAdapter(val items : ArrayList<PokeItem>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_poke_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val view = holder!!.itemView
        val nameView = view.findViewById<TextView>(R.id.poke_item_list_text)
        val desView = view.findViewById<TextView>(R.id.poke_item_list_des)
        val imageView = view.findViewById<ImageView>(R.id.poke_item_list_image)
        nameView?.text = items.get(position).name
        desView?.text = items.get(position).des
        imageView?.setImageResource(items.get(position).imageRes)
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tool_item = view.poke_item_list_image
    }

}