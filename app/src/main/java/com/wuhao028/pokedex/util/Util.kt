package com.wuhao028.pokedex.util

import com.wuhao028.pokedex.R

/**
 *Created by WuHao028 on 2/11/18
 */


var LAST_CLICK_TIME = 0L

fun getTypeImageRes(type: String): Int {
    var str = type.replace("\"", "")
    when (str) {
        "草" -> return R.drawable.grass
        "电" -> return R.drawable.electric
        "一般" -> return R.drawable.normal
        "虫" -> return R.drawable.bug
        "水" -> return R.drawable.water
        "地上" -> return R.drawable.ground
        "毒" -> return R.drawable.poison
        "妖精" -> return R.drawable.fairy
        "格斗" -> return R.drawable.fighting
        "飞行" -> return R.drawable.flying
        "岩石" -> return R.drawable.rock
        "幽灵" -> return R.drawable.ghost
        "钢" -> return R.drawable.steel
        "炎" -> return R.drawable.fire
        "超能" -> return R.drawable.psychic
        "超能力" -> return R.drawable.psychic
        "冰" -> return R.drawable.ice
        "龙" -> return R.drawable.dragon
        "恶" -> return R.drawable.normal
        else -> return 0
    }
}

fun getTypeText(type: String): String {
    var str = type.replace("\"", "")
    when (str) {
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
    var str = type.replace("\"", "")
    when (str) {
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


fun getTextColor(type: String): String {
    var str = type.replace("\"", "")
    when (str) {
        "草" -> return "#7bc657"
        "电" -> return "#f7ce43"
        "一般" -> return "#a8a77a"
        "虫" -> return "#a8b631"
        "水" -> return "#6a92ed"
        "地上" -> return "#dfbf6e"
        "毒" -> return "#9f449e"
        "妖精" -> return "#ec9aac"
        "格斗" -> return "#be312d"
        "飞行" -> return "#a893ed"
        "岩石" -> return "#b79f41"
        "幽灵" -> return "#705a96"
        "钢" -> return "#b8b8cf"
        "炎" -> return "#ee803b"
        "超能" -> return "#f65b89"
        "冰" -> return "#9ad8d7"
        "龙" -> return "#7043f4"
        "恶" -> return "#705849"
        else -> return "#000000"
    }
}

fun isFastClick(): Boolean {

    if (System.currentTimeMillis() - LAST_CLICK_TIME > 1000) {
        LAST_CLICK_TIME = System.currentTimeMillis()
        return false
    } else {
        return true
    }
}