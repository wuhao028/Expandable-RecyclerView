package com.wuhao028.pokedex.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.`interface`.RecyclerListener
import com.wuhao028.pokedex.adapter.PokeAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pokeAdapter = PokeAdapter(this, DataManager.instance.getPokemonData())
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = pokeAdapter
        mRecyclerView.setHasFixedSize(true);
    }

    override fun onClick(view: View, position: Int) {
        Toast.makeText(this, "this is it ", Toast.LENGTH_SHORT).show()
    }
}
