package com.wuhao028.pokedex.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.`interface`.RecyclerListener
import com.wuhao028.pokedex.model.ParentDataItem
import com.wuhao028.pokedex.view.PokeItemView
import kotlinx.android.synthetic.main.item_parent_child_listing.view.*


/**
 *Created by WuHao028 on 3/11/18
 */

class RecyclerViewAdapter(val parentDataItems: MutableList<ParentDataItem>, val listener: RecyclerListener) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerViewAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_parent_child_listing, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return parentDataItems.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        val dummyParentDataItem = parentDataItems[position]
        holder.itemView.tv_parentName.text = dummyParentDataItem.parentName
        holder.bind(dummyParentDataItem)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var context: Context? = null

        override fun onClick(view: View?) {
            if (view?.id == R.id.parent_header) {
                if (itemView.ll_child_items?.visibility == View.VISIBLE) {
                    itemView.ll_child_items?.visibility = View.GONE
                } else {
                    itemView.ll_child_items?.visibility = View.VISIBLE
                }
            } else {
                listener.onClick(view, view?.id)
            }
        }

        fun bind(dummyParentDataItem: ParentDataItem) {
            context = itemView.context
            itemView.ll_child_items?.visibility = View.GONE
            val intMaxNoOfChild = dummyParentDataItem.childDataItems.size

            for (indexView in 0 until intMaxNoOfChild) {
                itemView.ll_child_items.addView(PokeItemView(itemView.context))
            }
            itemView.parent_header?.setOnClickListener(this)


            val noOfChildTextViews = itemView.ll_child_items?.childCount

            val noOfChild = dummyParentDataItem.childDataItems.size

            if (noOfChild < noOfChildTextViews!!) {
                for (index in noOfChild until noOfChildTextViews) {
                    val currentTextView = itemView.ll_child_items!!.getChildAt(index)
                    currentTextView.visibility = View.GONE
                }
            }
            for (textViewIndex in 0 until noOfChild) {
                val currentTextView = itemView.ll_child_items!!.getChildAt(textViewIndex) as PokeItemView
                currentTextView.setImage(DataManager.instance.getDrawableID(dummyParentDataItem.childDataItems[textViewIndex].ename))
                currentTextView.setNumber("# " + textViewIndex)
                currentTextView.setTypes(dummyParentDataItem.childDataItems[textViewIndex].type)
                currentTextView.setName(dummyParentDataItem.childDataItems[textViewIndex].ename)
            }
        }
    }

}