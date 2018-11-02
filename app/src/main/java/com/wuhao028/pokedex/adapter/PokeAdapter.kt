package com.wuhao028.pokedex.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.JsonArray
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.`interface`.RecyclerListener
import com.wuhao028.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.item.view.*


/**
 *Created by WuHao028 on 1/11/18
 */

class PokeAdapter(val listener: RecyclerListener?, val data: List<Pokemon>) : RecyclerView.Adapter<PokeAdapter.ViewHolder>() {

    val tag = "PokeAdapter"

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        var number = position + 1
        holder?.name?.text =  data.get(position).ename
        holder?.poke_no?.text = "#"+number
        holder?.image?.setImageResource(DataManager.instance.getDrawableID(data.get(position).ename))
        listener?.let {
            holder?.itemView?.setOnClickListener {
                listener.onClick(holder?.itemView, position);
            }
        }
        val types:JsonArray = data.get(position).type
        Log.d(tag,types[0].toString())
        //TODO modify
        holder?.poke_type_one?.setImageResource(R.drawable.dragon)
        holder?.poke_type_two?.setImageResource(R.drawable.dark)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val image: ImageView
        val poke_no: TextView
        val poke_type_one: ImageView
        val poke_type_two: ImageView

        init {
            name = view.name
            image = view.image
            poke_no = view.poke_no
            poke_type_one = view.poke_type_one
            poke_type_two = view.poke_type_two
        }
    }

}