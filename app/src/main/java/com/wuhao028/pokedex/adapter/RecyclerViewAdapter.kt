package com.wuhao028.pokedex.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.model.ParentDataItem
import kotlinx.android.synthetic.main.item_parent_child_listing.view.*
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.`interface`.RecyclerListener

/**
 *Created by WuHao028 on 3/11/18
 */

class RecyclerViewAdapter(val parentDataItems: MutableList<ParentDataItem>,val listener: RecyclerListener) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

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
                listener.onClick(view,view?.id)
            }
        }

        fun bind(dummyParentDataItem: ParentDataItem) {
            context = itemView.context
            itemView.ll_child_items?.visibility = View.GONE
            val intMaxNoOfChild = dummyParentDataItem.childDataItems.size
//            val intMaxSizeTemp = dummyParentDataItem.childDataItems.size
//            if (intMaxSizeTemp > intMaxNoOfChild)
//                intMaxNoOfChild = intMaxSizeTemp

            for (indexView in 0 until intMaxNoOfChild) {

                val imageView = ImageView(context)
                imageView.id = indexView
                imageView.setPadding(0, 20, 0, 20)
                imageView.background = ContextCompat.getDrawable(context!!, R.drawable.background_sub_module_text)
                imageView.setImageResource(R.drawable.charmander)
                val text_layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                imageView.setOnClickListener(this)

                itemView.ll_child_items?.addView(imageView, text_layoutParams)

            }
            itemView.parent_header?.setOnClickListener(this)


            val noOfChildTextViews = itemView.ll_child_items?.childCount

            val noOfChild = dummyParentDataItem.childDataItems.size

            if (noOfChild < noOfChildTextViews!!) {
                for (index in noOfChild until noOfChildTextViews) {
                    val currentTextView = itemView.ll_child_items!!.getChildAt(index) as TextView
                    currentTextView.visibility = View.GONE
                }
            }
            for (textViewIndex in 0 until noOfChild) {
                val currentTextView = itemView.ll_child_items!!.getChildAt(textViewIndex) as ImageView
                currentTextView.setImageResource(DataManager.instance.getDrawableID(dummyParentDataItem.childDataItems[textViewIndex].ename))
            }
        }
    }

}