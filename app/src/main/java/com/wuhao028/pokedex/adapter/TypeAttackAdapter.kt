package com.wuhao028.pokedex.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.HorizontalScrollView
import android.widget.TextView
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.model.TypeAttack
import com.wuhao028.pokedex.ui.SyncHScrollView
import com.wuhao028.pokedex.util.getTypeBack

/**
 *Created by WuHao028 on 2/01/19
 */

class TypeAttackAdapter(context: Context,
                        /**
                         * layout ID
                         */
                        private val id_row_layout: Int,
                        /**
                         * List中的数据
                         */
                        private val currentData: MutableList<TypeAttack>,
                        /**
                         * ListView头部中的横向滑动视图
                         */
                        private val headScrollView: SyncHScrollView) : BaseAdapter() {
    private val mInflater: LayoutInflater


    init {
        this.mInflater = LayoutInflater.from(context)

    }

    override fun getCount(): Int {
        return this.currentData.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    /**
     * 向List中添加数据
     *
     * @param items
     */
    fun addItem(items: List<TypeAttack>) {
        for (item in items) {
            currentData.add(item)
        }
    }

    /**
     * 清空当List中的数据
     */
    fun cleanAll() {
        this.currentData.clear()
    }

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parentView: ViewGroup): View {
        var convertView = convertView
        var holder: ViewHolder? = null
        if (convertView == null) {
            convertView = mInflater.inflate(id_row_layout, null)
            holder = ViewHolder()

            //获取当前条目中的右侧滑动控件
            val scrollView1 = convertView!!.findViewById<SyncHScrollView>(R.id.horizontalScrollView1)

            //TODO 划重点：这里需要从传入的列表头拿到里面的右侧滑动控件
            //将当前条目的右侧滑动控件添加到头部滑动控件的滑动观察者集合中
            headScrollView.AddOnScrollChangedListener(OnScrollChangedListenerImp(scrollView1))

            //进行holder的初始化操作
            holder.scrollView = scrollView1
            holder.header = convertView.findViewById(R.id.attack_header)
            holder.txt1 = convertView.findViewById(R.id.attack_textView1)
            holder.txt2 = convertView.findViewById(R.id.attack_textView2)
            holder.txt3 = convertView.findViewById(R.id.attack_textView3)
            holder.txt4 = convertView.findViewById(R.id.attack_textView4)
            holder.txt5 = convertView.findViewById(R.id.attack_textView5)
            holder.txt6 = convertView.findViewById(R.id.attack_textView6)
            holder.txt7 = convertView.findViewById(R.id.attack_textView7)
            holder.txt8 = convertView.findViewById(R.id.attack_textView8)
            holder.txt9 = convertView.findViewById(R.id.attack_textView9)
            holder.txt10 = convertView.findViewById(R.id.attack_textView10)
            holder.txt11 = convertView.findViewById(R.id.attack_textView11)
            holder.txt12 = convertView.findViewById(R.id.attack_textView12)
            holder.txt13 = convertView.findViewById(R.id.attack_textView13)
            holder.txt14 = convertView.findViewById(R.id.attack_textView14)
            holder.txt15 = convertView.findViewById(R.id.attack_textView15)
            holder.txt16 = convertView.findViewById(R.id.attack_textView16)
            holder.txt17 = convertView.findViewById(R.id.attack_textView17)
            holder.txt18 = convertView.findViewById(R.id.attack_textView18)

            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.header!!.text = currentData[position].header
        holder.header!!.setBackgroundResource(getTypeBack(currentData[position].header))
        holder.txt1!!.text = currentData[position].type1!!
        holder.txt2!!.text = currentData[position].type2!!
        holder.txt3!!.text = currentData[position].type3!!
        holder.txt4!!.text = currentData[position].type4!!
        holder.txt5!!.text = currentData[position].type5!!
        holder.txt6!!.text = currentData[position].type6!!
        holder.txt7!!.text = currentData[position].type7!!
        holder.txt8!!.text = currentData[position].type8!!
        holder.txt9!!.text = currentData[position].type9!!
        holder.txt10!!.text = currentData[position].type10!!
        holder.txt11!!.text = currentData[position].type11!!
        holder.txt12!!.text = currentData[position].type12!!
        holder.txt13!!.text = currentData[position].type13!!
        holder.txt14!!.text = currentData[position].type14!!
        holder.txt15!!.text = currentData[position].type15!!
        holder.txt16!!.text = currentData[position].type16!!
        holder.txt17!!.text = currentData[position].type17!!
        holder.txt18!!.text = currentData[position].type18!!
        return convertView
    }

    open class OnScrollChangedListenerImp(var mScrollViewArg: SyncHScrollView) :
            SyncHScrollView.OnScrollChangedListener {

        override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
            mScrollViewArg.smoothScrollTo(l, t)
        }
    }

    internal inner class ViewHolder {
        var header: TextView? = null
        var txt1: TextView? = null
        var txt2: TextView? = null
        var txt3: TextView? = null
        var txt4: TextView? = null
        var txt5: TextView? = null
        var txt6: TextView? = null
        var txt7: TextView? = null
        var txt8: TextView? = null
        var txt9: TextView? = null
        var txt10: TextView? = null
        var txt11: TextView? = null
        var txt12: TextView? = null
        var txt13: TextView? = null
        var txt14: TextView? = null
        var txt15: TextView? = null
        var txt16: TextView? = null
        var txt17: TextView? = null
        var txt18: TextView? = null
        var scrollView: HorizontalScrollView? = null
    }

    companion object {
        private val TAG = TypeAttackAdapter::class.java.name
    }

}
