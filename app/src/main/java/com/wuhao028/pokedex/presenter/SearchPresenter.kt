package com.wuhao028.pokedex.presenter

import com.wuhao028.pokedex.Constants.Companion.MAX_POKEMON_NUMBER
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.model.Pokemon
import java.util.regex.Pattern

/**
 *Created by WuHao028 on 9/12/18
 */

class SearchPresenter {
    lateinit var view: PokeSearchView

    fun attachView(activity: PokeSearchView) {
        view = activity
    }

    fun querySearchData(words: String) {
        var result: MutableList<Pokemon> = arrayListOf()

        if (isNumberic(words)) {
            val pokeNumber = Integer.parseInt(words)
            if (pokeNumber > 0 && pokeNumber < MAX_POKEMON_NUMBER) {
                result.add(DataManager.instance.getPokemonData()[pokeNumber - 1])
            }
        }

        for (pokemon in DataManager.instance.getPokemonData()) {
            if (pokemon.ename?.toLowerCase().contains(words?.toLowerCase()) || pokemon.cname.contains(words)) {
                result.add(pokemon)
            }
        }

        if (result?.size != 0) {
            view.setSearchResult(result)
        } else {
            view.setEmptyView()
        }

    }

    fun isNumberic(str: String): Boolean {
        val pattern = Pattern.compile("[0-9]*")
        return pattern.matcher(str).matches()
    }

    interface PokeSearchView {

        fun setSearchResult(result: MutableList<Pokemon>)

        fun setEmptyView()

    }
}