package com.wuhao028.pokedex.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.wuhao028.pokedex.Constants
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import kotlinx.android.synthetic.main.activity_detail.*
import org.json.JSONArray

/**
 *Created by WuHao028 on 2/11/18
 */

class DetailActivity : AppCompatActivity(){

    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail)

        id = getIntent().getIntExtra(Constants.POKEMON_ID,0)
        var pokemon=DataManager.instance.getPokemonData().get(id)
        pokename.setText(pokemon.ename)
        pokeimage.setImageResource(DataManager.instance.getDrawableID("hd"+pokemon.ename))

        var baseObject = pokemon.base
        poke_atk_value.setText(baseObject.get(Constants.ATTACK).toString())
        poke_def_value.setText(baseObject.get(Constants.DEFENSE).toString())
        poke_hp_value.setText(baseObject.get(Constants.HP).toString())
        poke_spatk_value.setText(baseObject.get(Constants.SPATK).toString())
        poke_spdef_value.setText(baseObject.get(Constants.SPDEF).toString())
        poke_speed_value.setText(baseObject.get(Constants.SPEED).toString())
    }
}