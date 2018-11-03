package com.wuhao028.pokedex.view

import android.annotation.TargetApi
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.google.gson.JsonArray
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.util.getTypeImageRes
import kotlinx.android.synthetic.main.item.view.*

/**
 *Created by WuHao028 on 3/11/18
 */

class PokeItemView : LinearLayout {

    constructor(context: Context) : super(context) {
        init(context, null, null, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs, null, null)
    }

    constructor(ctx: Context, attr: AttributeSet?, defStyle: Int) : super(ctx, attr, defStyle) {
        init(ctx, attr, defStyle, null)
    }

    @TargetApi(21)
    constructor(ctx: Context, attr: AttributeSet?, defStyle: Int, defStyleRes: Int)
            : super(ctx, attr, defStyle, defStyleRes) {
        init(ctx, attr, defStyle, defStyleRes)
    }


    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int?, defStyleRes: Int?) {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.item, this, true)

    }

    fun setName(pokeName: String) {
        name.text = pokeName
    }

    fun setImage(resId: Int) {
        image.setImageResource(resId)
    }

    fun setTypes(jasonArray: JsonArray) {

         if(jasonArray?.size() == 1) {
             poke_type_one.visibility = View.VISIBLE
             poke_type_two.visibility = View.INVISIBLE
             poke_type_one.setImageResource(getTypeImageRes(jasonArray[0].toString().replace("\"","")))
         }
        if(jasonArray?.size() == 2){
            poke_type_one.visibility = View.VISIBLE
            poke_type_two.visibility = View.VISIBLE
            poke_type_one.setImageResource(getTypeImageRes(jasonArray[0].toString().replace("\"","")))
            poke_type_two.setImageResource(getTypeImageRes(jasonArray[1].toString().replace("\"","")))
        }
    }

    fun setNumber(numberStr: String) {
        poke_no.text = numberStr
    }


}