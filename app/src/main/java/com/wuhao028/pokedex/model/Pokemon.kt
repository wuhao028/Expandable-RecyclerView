package com.wuhao028.pokedex.model

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject

/**
 *Created by WuHao028 on 31/10/18
 */

data class Pokemon(@SerializedName("base") val base: JsonObject,
                   @SerializedName("cnname") val cnname: String,
                   @SerializedName("enname") val enname: String,
                   @SerializedName("jpname") val jpname: String,
                   @SerializedName("id") val id: String,
                   @SerializedName("skills") val skills: JsonObject,
                   @SerializedName("type") val type: JsonArray)

