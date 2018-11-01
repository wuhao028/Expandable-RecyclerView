package com.wuhao028.pokedex

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.wuhao028.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.item.view.*

/**
 *Created by WuHao028 on 1/11/18
 */

class PokeAdapter(val listener:RecyclerListener?,val data:List<Pokemon>): RecyclerView.Adapter<PokeAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.name?.text = data.get(position).id
        holder?.image?.setImageResource(R.drawable.charmander)
        listener?.let {
            holder?.itemView?.setOnClickListener {
                listener.onClick(holder?.itemView,position);
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name: TextView
        val image: ImageView

        init {
            name = view.name
            image = view.image
        }

    }

}