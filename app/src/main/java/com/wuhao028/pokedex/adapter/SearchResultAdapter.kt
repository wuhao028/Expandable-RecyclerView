package com.wuhao028.pokedex.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.model.Pokemon
import com.wuhao028.pokedex.util.isFastClick
import kotlinx.android.synthetic.main.layout_item.view.*

/**
 *Created by WuHao028 on 10/12/18
 */

class SearchResultAdapter(val mOnItemClickLitener: RecyclerItemClickListenner?, val mDatas: MutableList<Pokemon>) : RecyclerView.Adapter<SearchResultAdapter.myHolderView>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): myHolderView {

        return myHolderView(LayoutInflater.from(parent?.context).inflate(R.layout.layout_item, parent, false))
    }

    override fun onBindViewHolder(holder: myHolderView?, position: Int) {

        val id = Integer.parseInt(mDatas.get(position).id)

        holder?.poke_name?.text = mDatas.get(position)?.ename
        holder?.poke_no?.text = "# " + id
        holder?.poke_image?.setImageResource(DataManager.instance.getMipmapID(mDatas.get(position)?.ename))

        mOnItemClickLitener?.let {
            holder?.itemView?.setOnClickListener {
                if (!isFastClick()) {
                    mOnItemClickLitener.onRecyclerViewItemClick(holder?.itemView, id - 1)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mDatas.count()

    }

    class myHolderView(view: View) : RecyclerView.ViewHolder(view) {
        val poke_name: TextView
        val poke_no: TextView
        val poke_image: ImageView

        init {
            poke_name = view.poke_name
            poke_no = view.poke_no
            poke_image = view.poke_image
        }

    }

    interface RecyclerItemClickListenner {
        fun onRecyclerViewItemClick(view: View, position: Int)
    }
}