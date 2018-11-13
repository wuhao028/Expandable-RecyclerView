package com.wuhao028.pokedex.ui

import android.opengl.Visibility
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import com.wuhao028.pokedex.Constants
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.util.getTypeImageRes
import com.wuhao028.pokedex.util.getTypeText
import kotlinx.android.synthetic.main.activity_detail.*

/**
 *Created by WuHao028 on 2/11/18
 */

class DetailActivity : AppCompatActivity() {

    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getSupportActionBar()?.hide()
        setContentView(R.layout.activity_detail)

        id = getIntent().getIntExtra(Constants.POKEMON_ID, 0)
        var pokemon = DataManager.instance.getPokemonData().get(id)
        pokename.setText(pokemon.ename)
        pokeimage.setImageResource(DataManager.instance.getMipmapID("hd" + pokemon.ename))

        var baseObject = pokemon.base
        poke_atk_value.setText(baseObject.get(Constants.ATTACK).toString())
        poke_def_value.setText(baseObject.get(Constants.DEFENSE).toString())
        poke_hp_value.setText(baseObject.get(Constants.HP).toString())
        poke_spatk_value.setText(baseObject.get(Constants.SPATK).toString())
        poke_spdef_value.setText(baseObject.get(Constants.SPDEF).toString())
        poke_speed_value.setText(baseObject.get(Constants.SPEED).toString())

        val typeArray = pokemon.type
        if(typeArray.size() == 1){
            poke_type_image_one.setImageResource(getTypeImageRes(typeArray[0].toString()))
            poke_type_word_one.setText(getTypeText(typeArray[0].toString().replace(" ","")).toUpperCase())
            poke_type_image_two.visibility = GONE
            poke_type_image_one.visibility = VISIBLE
            poke_type_word_one.visibility = VISIBLE
            poke_type_word_two.visibility = GONE
        }else if(typeArray.size() == 2){
            poke_type_image_one.setImageResource(getTypeImageRes(typeArray[0].toString()))
            poke_type_image_two.setImageResource(getTypeImageRes(typeArray[1].toString()))
            poke_type_word_one.setText(getTypeText(typeArray[0].toString().replace(" ","")).toUpperCase())
            poke_type_word_two.setText(getTypeText(typeArray[1].toString().replace(" ","")).toUpperCase())
            poke_type_image_one.visibility = VISIBLE
            poke_type_image_two.visibility = VISIBLE
            poke_type_word_one.visibility = VISIBLE
            poke_type_word_two.visibility = VISIBLE
        }

        jp_name.setText(pokemon.jname)
        cn_name.setText(pokemon.cname)

    }
}