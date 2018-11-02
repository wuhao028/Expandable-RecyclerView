package com.wuhao028.pokedex.model

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONObject

/**
 *Created by WuHao028 on 31/10/18
 */

data class Pokemon(val base: JSONObject,
                   val cname: String,
                   val ename: String,
                   val jname: String,
                   val id: String,
                   val skills: JsonObject,
                   val type: JsonArray)

