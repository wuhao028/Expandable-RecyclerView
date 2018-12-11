package com.wuhao028.pokedex

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.wuhao028.pokedex.model.Pokemon
import com.wuhao028.pokedex.model.Skill
import org.json.JSONArray


/**
 *Created by WuHao028 on 1/11/18
 */

class DataManager private constructor() {

    lateinit var pokemons: JSONArray
    lateinit var skillsArray: JSONArray
    lateinit var data: MutableList<Pokemon>
    lateinit var skillData: MutableList<Skill>

    val tag: String = "DataManager"

    companion object {
        val instance: DataManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            DataManager()
        }
    }

    fun initDataManager(context: Context) {
        val assetManager = context.getAssets()

        //Parse Pokemon
        val json_String = assetManager.open(Constants.POKEMON_JSON).bufferedReader().use { it.readText() }
        try {
            pokemons = JSONArray(json_String)
        } catch (e: Exception) {
            Log.e(tag, e.message)
        }
        val gson = Gson()
        data = arrayListOf()
        for (i in 0..pokemons.length() - 1) {
            data.add(gson.fromJson(pokemons[i].toString(), Pokemon::class.java))
        }

        //Parse Skill
        val skill_json_String = assetManager.open(Constants.SKILL_JSON).bufferedReader().use { it.readText() }
        try {
            skillsArray = JSONArray(skill_json_String)
        } catch (e: Exception) {
            Log.e(tag, e.message)
        }
        skillData = arrayListOf()
        for (t in 0..skillsArray.length() - 1) {
            skillData.add(gson.fromJson(skillsArray[t].toString(), Skill::class.java))
        }

    }

    fun getPokemonData(): List<Pokemon> {
        return data
    }

    fun getPokemonFirstGen(): List<Pokemon> {
        return data.subList(0, 151)
    }

    fun getPokemonSecondGen(): List<Pokemon> {
        return data.subList(151, 251)
    }

    fun getPokemonThirdGen(): List<Pokemon> {
        return data.subList(251, 386)
    }

    fun getPokemonFourthGen(): List<Pokemon> {
        return data.subList(386, 494)
    }

    fun getMipmapID(name: String): Int {
        return PokeApplication.context.getResources().getIdentifier(name?.filterAlph(), "mipmap", PokeApplication.context.getPackageName())
    }

    fun getSkill(id: Int): Skill {
        if (id > skillData.size) {
            return Skill("", "", "", "", "", 0, 0, 0, "")
        } else
            return skillData[id]
    }

}

