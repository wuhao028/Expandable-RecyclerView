package com.wuhao028.pokedex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.`interface`.RecyclerListener
import com.wuhao028.pokedex.model.Pokemon
import com.wuhao028.pokedex.util.getTypeImageRes

/**
 *Created by WuHao028 on 4/11/18
 */

class ExpandableListAdapter(var context: Context,
                            var expandableListView : ExpandableListView,
                            var header : MutableList<String>,
                            var body : MutableList<MutableList<Pokemon>>,
                            var listener: RecyclerListener) : BaseExpandableListAdapter(){
    override fun getGroup(groupPosition: Int): String {
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
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_group,null)
        }
        val title = convertView?.findViewById<TextView>(R.id.tv_title)
        title?.text = getGroup(groupPosition)
        title?.setOnClickListener {
            if(expandableListView.isGroupExpanded(groupPosition))
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
        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_item,null)
        }
        val poke_title = convertView?.findViewById<TextView>(R.id.poke_name)
        val poke_no = convertView?.findViewById<TextView>(R.id.poke_no)
        val poke_image = convertView?.findViewById<ImageView>(R.id.poke_image)
        val poke_type_one = convertView?.findViewById<ImageView>(R.id.poke_type_one)
        val poke_type_two = convertView?.findViewById<ImageView>(R.id.poke_type_two)
        poke_title?.text = getChild(groupPosition,childPosition)?.ename + " " +childPosition
        poke_no?.text = "# "+getChild(groupPosition,childPosition)?.id
        poke_image?.setImageResource(DataManager.instance.getDrawableID(getChild(groupPosition,childPosition)?.ename))

        convertView?.setOnClickListener {
            listener.onClick(convertView,getChild(groupPosition,childPosition)?.id?.toInt() - 1)
        }
        val jasonArray = getChild(groupPosition,childPosition)?.type

        if(jasonArray?.size() == 1) {
            poke_type_one?.visibility= View.VISIBLE
            poke_type_two?.visibility = View.INVISIBLE
            poke_type_one?.setImageResource(getTypeImageRes(jasonArray[0].toString().replace("\"","")))
        }
        if(jasonArray?.size() == 2){
            poke_type_one?.visibility = View.VISIBLE
            poke_type_two?.visibility = View.VISIBLE
            poke_type_one?.setImageResource(getTypeImageRes(jasonArray[0].toString().replace("\"","")))
            poke_type_two?.setImageResource(getTypeImageRes(jasonArray[1].toString().replace("\"","")))
        }

        return convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return header.size
    }

}