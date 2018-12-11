package com.wuhao028.pokedex.model

import java.io.Serializable

/**
 *Created by WuHao028 on 16/11/18
 */

data class GenHeader(val genImageId: Int, val genTitle: String, val totalNum: Int) : Serializable