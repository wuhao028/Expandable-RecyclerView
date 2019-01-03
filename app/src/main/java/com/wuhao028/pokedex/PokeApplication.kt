package com.wuhao028.pokedex

import android.app.Application
import android.content.Context
import android.util.Log
import kotlin.properties.Delegates


/**
 *Created by WuHao028 on 31/10/18
 */
class PokeApplication : Application() {

    companion object {

        private val TAG = "PokeApplication"

        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        DataManager.instance.initDataManager(this)
        context = this.applicationContext
    }

}