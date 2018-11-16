package com.wuhao028.pokedex.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wuhao028.pokedex.Constants
import com.wuhao028.pokedex.DataManager
import com.wuhao028.pokedex.R
import com.wuhao028.pokedex.`interface`.RecyclerListener
import com.wuhao028.pokedex.adapter.ExpandableListAdapter
import com.wuhao028.pokedex.model.GenHeader
import com.wuhao028.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.fragment_pokedex.*

class PokedexFragment : Fragment(), RecyclerListener {

    val header: MutableList<GenHeader> = ArrayList()
    val body: MutableList<MutableList<Pokemon>> = ArrayList()
    private var mTitle: String? = null
    private var num: Int = 1

    companion object {
        fun getInstance(title: String): PokedexFragment {
            val fragment = PokedexFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pokedex, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    fun initData() {
        val gen1: MutableList<Pokemon> = ArrayList()
        gen1.addAll(DataManager.instance.getPokemonFirstGen())

        val gen2: MutableList<Pokemon> = ArrayList()
        gen2.addAll(DataManager.instance.getPokemonSecondGen())

        val gen3: MutableList<Pokemon> = ArrayList()
        gen3.addAll(DataManager.instance.getPokemonThirdGen())

        val gen4: MutableList<Pokemon> = ArrayList()
        gen4.addAll(DataManager.instance.getPokemonFourthGen())

        header.add(GenHeader(R.mipmap.firstgen_pic,"Kanto Region"))
        header.add(GenHeader(R.mipmap.secondgen_pic,"Johto Region"))
        header.add(GenHeader(R.mipmap.thirdgen_pic,"Hoenn Region"))
        header.add(GenHeader(R.mipmap.fourthgen_pic,"Sinnoh Region"))
        body.add(gen1)
        body.add(gen2)
        body.add(gen3)
        body.add(gen4)

        expandableListView?.addHeaderView(LayoutInflater.from(activity).inflate(R.layout.list_header, null))
        expandableListView?.setAdapter(ExpandableListAdapter(activity, expandableListView, header, body, this))
    }

    override fun onClick(view: View?, position: Int?) {
        if (position != null) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(Constants.POKEMON_ID, position)
            this.startActivity(intent)
        }
    }


}
