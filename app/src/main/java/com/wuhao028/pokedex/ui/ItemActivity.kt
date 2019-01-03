package com.wuhao028.pokedex.ui

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.adapter.ItemAdapter
import com.wuhao028.pokedex.model.PokeItem
import kotlinx.android.synthetic.main.activity_item.*
import java.util.*
import kotlin.collections.ArrayList

/**
 *Created by WuHao028 on 3/01/19
 */

class ItemActivity: Activity(){

    val itemData: ArrayList<PokeItem> = ArrayList()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        initData()
        poke_item_recyclerview.layoutManager = LinearLayoutManager(this)
        poke_item_recyclerview.adapter = ItemAdapter(itemData,this)
        poke_item_recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    fun initData(){
        itemData.add(PokeItem("Potion",R.mipmap.item_potion,"A spray-type medicine that restores the HP of one Pokémon by 20 points."))
        itemData.add(PokeItem("Super Potion",R.mipmap.item_super_potion,"A spray-type medicine that restores the HP of one Pokémon by 50 points."))
        itemData.add(PokeItem("Hyper Potion",R.mipmap.item_hyper_potion,"A spray-type medicine that restores the HP of one Pokémon by 200 points."))
        itemData.add(PokeItem("Max Potion",R.mipmap.item_max_potion,"A spray-type medicine that completely restores all HP of a single Pokémon."))
        itemData.add(PokeItem("Razz Berry",R.mipmap.item_razz_berry,"Feed this to a Pokémon to make it easier to catch."))
        itemData.add(PokeItem("Nanab Berry",R.mipmap.item_nanab_berry,"Reduces the likelihood of a Pokemon moving or attacking by a factor of 20. Also restores slightly more motivation when used in a Gym."))
        itemData.add(PokeItem("Pinap Berry",R.mipmap.item_pinap_berry,"Rewards 2x Candy if the Pokemon is caught on the next successful throw."))
        itemData.add(PokeItem("Golden Razz Berry",R.mipmap.item_golden_razz_berry,"Feed this to a Pokemon to make it much easier to catch."))
        itemData.add(PokeItem("Revive",R.mipmap.item_revive,"A medicine that can revive fainted Pokémon. It also restores half of a fainted Pokémon's maximum HP."))
        itemData.add(PokeItem("Max Revive",R.mipmap.item_max_revive,"A medicine that can revive fainted Pokémon. It also fully restores a fainted Pokémon's maximum HP."))
        itemData.add(PokeItem("Sun Stone",R.mipmap.item_sun_stone,"Evolves Gloom to Bellossom (with 100 Oddish Candy) and Sunkern to Sunflora (with 50 Sunkern Candy)."))
        itemData.add(PokeItem("King's Rock",R.mipmap.item__kings_rock,"Evolves Poliwhirl to Politoed (with 100 Poliwag Candy) and Slowpoke to Slowking (with 50 Slowpoke Candy)."))
        itemData.add(PokeItem("Metal Coat",R.mipmap.item_metal_coat,"Evolves Onix to Steelix (with 50 Onix Candy) and Scyther to Scizor (with 50 Scyther Candy)."))
        itemData.add(PokeItem("Dragon Scale",R.mipmap.item_dragon_scale,"Evolves Seadra to Kingdra (with 100 Horsea Candy)."))
        itemData.add(PokeItem("Up-Grade",R.mipmap.item_up_grade,"Evolves Porygon to Porygon2 (with 50 Porygon Candy)."))
    }

}