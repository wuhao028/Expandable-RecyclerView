package com.wuhao028.pokedex

import android.app.Application
import android.util.Log
import android.content.res.AssetManager
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception


/**
 *Created by WuHao028 on 31/10/18
 */
class PokeApplication : Application(){


    override fun onCreate() {
        super.onCreate()
        Log.d("PokeApplication","application begin")
        val assetManager = this.getAssets()
        val json_String=assetManager.open("pokedex.json").bufferedReader().use { it.readText() }


        try{
            val jsonArray :JSONArray= JSONArray(json_String)
            Log.d("PokeApplication",jsonArray[0].toString())
        }catch (e:Exception){

        }

    }

}