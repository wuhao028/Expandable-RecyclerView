package com.wuhao028.pokedex.util

import com.wuhao028.pokedex.R

/**
 *Created by WuHao028 on 2/11/18
 */


fun getTypeImageRes(type: String): Int {
    when (type) {
        "草" -> return R.drawable.grass
        "电" -> return R.drawable.electric
        "一般" -> return R.drawable.normal
        "虫" -> return R.drawable.bug
        "水" -> return R.drawable.water
        "地上" -> return R.drawable.ground
        "毒" -> return R.drawable.posion
        "妖精" -> return R.drawable.fairy
        "格斗" -> return R.drawable.fighting
        "飞行" -> return R.drawable.flying
        "岩石" -> return R.drawable.rock
        "幽灵" -> return R.drawable.ghost
        "钢" -> return R.drawable.steel
        "炎" -> return R.drawable.fire
        "超能" -> return R.drawable.psychic
        "冰" -> return R.drawable.ice
        "龙" -> return R.drawable.dragon
        "恶" -> return R.drawable.normal
        else -> return 0
    }
}

fun getTypeText(type: String): String {
    when (type) {
        "草" -> return "  grass  "
        "电" -> return "  electric  "
        "一般" -> return "  normal  "
        "虫" -> return "  bug  "
        "水" -> return "  water  "
        "地上" -> return "  ground  "
        "毒" -> return "  poison  "
        "妖精" -> return "  fairy  "
        "格斗" -> return "  fighting  "
        "飞行" -> return "  flying  "
        "岩石" -> return "  rock  "
        "幽灵" -> return "  ghost  "
        "钢" -> return "  steel  "
        "炎" -> return "  fire  "
        "超能" -> return "  psychic  "
        "冰" -> return "  ice  "
        "龙" -> return "  dragon  "
        "恶" -> return "  normal  "
        else -> return " "
    }
}

fun getTypeBackground(type: String): Int {
    when (type) {
        "草" -> return R.drawable.poke_type_grass
        "电" -> return R.drawable.poke_type_electric
        "一般" -> return R.drawable.poke_type_normal
        "虫" -> return R.drawable.poke_type_bug
        "水" -> return R.drawable.poke_type_water
        "地上" -> return R.drawable.poke_type_ground
        "毒" -> return R.drawable.poke_type_posion
        "妖精" -> return R.drawable.poke_type_fairy
        "格斗" -> return R.drawable.poke_type_fighting
        "飞行" -> return R.drawable.poke_type_flying
        "岩石" -> return R.drawable.poke_type_rock
        "幽灵" -> return R.drawable.poke_type_ghost
        "钢" -> return R.drawable.poke_type_steel
        "炎" -> return R.drawable.poke_type_fire
        "超能" -> return R.drawable.poke_type_psychic
        "冰" -> return R.drawable.poke_type_ice
        "龙" -> return R.drawable.poke_type_dragon
        "恶" -> return R.drawable.poke_type_dark
        else -> return 0
    }
}