package com.wuhao028.pokedex.presenter

import android.app.Activity
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.model.Pokemon
import java.util.regex.Pattern

/**
 *Created by WuHao028 on 9/12/18
 */

class SearchPresenter{
    lateinit var view:PokeSearchView

    fun attachView(activity: PokeSearchView){
        view = activity
    }

    fun querySearchData(words: String){
        var result: MutableList<Pokemon> = arrayListOf()

        if(isNumberic(words)){

        }

        for(pokemon in DataManager.instance.getPokemonFirstGen()){
            if(pokemon.ename.contains(words) || pokemon.cname.contains(words)){
                result.add(pokemon)
            }
        }

        if(result?.size!=0){
            view.setSearchResult(result)
        }else{
            view.setEmptyView()
        }

    }

    fun isNumberic(str: String): Boolean{
        val pattern = Pattern.compile("[0-9]*")
        return pattern.matcher(str).matches()
    }

    interface PokeSearchView {

        fun setSearchResult(result: MutableList<Pokemon>)

        fun setEmptyView()

    }
}