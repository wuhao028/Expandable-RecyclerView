package com.wuhao028.pokedex.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.wuhao028.pokedex.Constants
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.`interface`.RecyclerListener
import com.wuhao028.pokedex.adapter.ExpandableListAdapter
import com.wuhao028.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerListener {

    val header: MutableList<String> = ArrayList()
    val body: MutableList<MutableList<Pokemon>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getSupportActionBar()?.hide()
        setContentView(R.layout.activity_main)

        val season1: MutableList<Pokemon> = ArrayList()
        season1.addAll(DataManager.instance.getPokemonData())

        header.add("Kanto")
        body.add(season1)

        expandableListView.setAdapter(ExpandableListAdapter(this,expandableListView, header, body,this))
    }

    override fun onClick(view: View?, position: Int?) {
        if (position != null) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(Constants.POKEMON_ID, position)
            this.startActivity(intent)
        }
    }


}
