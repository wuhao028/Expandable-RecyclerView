package com.wuhao028.pokedex.model

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import java.io.Serializable

/**
 *Created by WuHao028 on 31/10/18
 */

data class Pokemon(val base: JsonObject,
                   val cname: String,
                   val ename: String,
                   val jname: String,
                   val id: String,
                   val skills: JsonObject,
                   val type: JsonArray) : Serializable

