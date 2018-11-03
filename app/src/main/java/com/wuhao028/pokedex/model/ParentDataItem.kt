package com.wuhao028.pokedex.model

import java.io.Serializable

/**
 *Created by WuHao028 on 3/11/18
 */

data class ParentDataItem(val parentName: String,
                          val childDataItems: List<Pokemon>) : Serializable