package com.wuhao028.pokedex

import android.app.Application
import android.util.Log


/**
 *Created by WuHao028 on 31/10/18
 */
class PokeApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        Log.d("PokeApplication", "application begin")
        DataManager.instance.initDataManager(this)
    }

}