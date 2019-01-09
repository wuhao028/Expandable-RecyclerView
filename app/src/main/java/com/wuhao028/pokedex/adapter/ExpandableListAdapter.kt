package com.wuhao028.pokedex.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.`interface`.RecyclerListener
import com.wuhao028.pokedex.model.GenHeader
import com.wuhao028.pokedex.model.Pokemon
import com.wuhao028.pokedex.util.getTypeBackground
import com.wuhao028.pokedex.util.getTypeText
import kotlinx.android.synthetic.main.layout_item.view.*

/**
 *Created by WuHao028 on 4/11/18
 */

class ExpandableListAdapter(var context: Context,
                            var expandableListView: ExpandableListView,
                            var header: MutableList<GenHeader>,
                            var body: MutableList<MutableList<Pokemon>>,
                            var listener: RecyclerListener) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): GenHeader {
        return header[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_group, null)
        }
        val genTitle = convertView?.findViewById<TextView>(R.id.generation_title)
        val genTotalNumber = convertView?.findViewById<TextView>(R.id.generation_total_num)
        val genImage = convertView?.findViewById<ImageView>(R.id.generation_image)
        genTitle?.text = getGroup(groupPosition).genTitle
        genTotalNumber?.text = getGroup(groupPosition).totalNum?.toString()
        genImage?.setImageResource(getGroup(groupPosition).genImageId)

        genTitle?.setOnClickListener {
            if (expandableListView.isGroupExpanded(groupPosition))
                expandableListView.collapseGroup(groupPosition)
            else
                expandableListView.expandGroup(groupPosition)
//            Toast.makeText(context, getGroup(groupPosition), Toast.LENGTH_SHORT).show()
        }
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return body[groupPosition].size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Pokemon {
        return body[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        var viewHolder: ChildHolder
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_item, null)
            viewHolder = ChildHolder(convertView)
            convertView.setTag(viewHolder)
        } else {
            viewHolder = convertView?.getTag() as ChildHolder
        }

        viewHolder.poke_title?.text = getChild(groupPosition, childPosition)?.ename
        viewHolder.poke_no?.text = "# " + getChild(groupPosition, childPosition)?.id
        viewHolder.poke_image?.setImageResource(DataManager.instance.getMipmapID(getChild(groupPosition, childPosition)?.ename))

        convertView?.setOnClickListener {
            listener.onClick(convertView, getChild(groupPosition, childPosition)?.id?.toInt() - 1)
        }
        val jasonArray = getChild(groupPosition, childPosition)?.type
        if (jasonArray?.size() == 1) {
            viewHolder.poke_type_one?.visibility = View.VISIBLE
            viewHolder.poke_type_two?.visibility = View.INVISIBLE
            viewHolder.poke_type_one?.setBackgroundResource(getTypeBackground(jasonArray[0].toString()))
            viewHolder.poke_type_one?.setText(getTypeText(jasonArray[0].toString()))
        }
        if (jasonArray?.size() == 2) {
            viewHolder.poke_type_one?.visibility = View.VISIBLE
            viewHolder.poke_type_two?.visibility = View.VISIBLE
            viewHolder.poke_type_one?.setText(getTypeText(jasonArray[0].toString()))
            viewHolder.poke_type_two?.setText(getTypeText(jasonArray[1].toString()))
            viewHolder.poke_type_one?.setBackgroundResource(getTypeBackground(jasonArray[0].toString()))
            viewHolder.poke_type_two?.setBackgroundResource(getTypeBackground(jasonArray[1].toString()))

        }
        return convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return header.size
    }


    class ChildHolder(view: View) : RecyclerView.ViewHolder(view) {
        val poke_title: TextView
        val poke_no: TextView
        val poke_type_one: TextView
        val poke_type_two: TextView
        val poke_image: ImageView

        init {
            poke_title = view.poke_name
            poke_no = view.poke_no
            poke_image = view.poke_image
            poke_type_one = view.poke_type_one
            poke_type_two = view.poke_type_two
        }

    }
}