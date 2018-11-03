package com.wuhao028.pokedex.util

import com.wuhao028.pokedex.R

/**
 *Created by WuHao028 on 2/11/18
 */


fun getTypeImageRes(type: String):Int{
    when (type){
        "草" ->  return R.drawable.grass
        "电" ->  return R.drawable.electric
        "一般" -> return R.drawable.normal
        "虫" -> return R.drawable.bug
        "水" -> return R.drawable.water
        "地上" ->  return R.drawable.ground
        "毒" ->  return R.drawable.posion
        "妖精" -> return R.drawable.fairy
        "格斗" -> return R.drawable.fighting
        "飞行" -> return R.drawable.flying
        "岩石" ->  return R.drawable.rock
        "幽灵" ->  return R.drawable.ghost
        "钢" -> return R.drawable.steel
        "炎" -> return R.drawable.fire
        "超能" -> return R.drawable.psychic
        "冰" ->  return R.drawable.ice
        "龙" ->  return R.drawable.dragon
        "恶" -> return R.drawable.normal
        else -> return 0
    }
}