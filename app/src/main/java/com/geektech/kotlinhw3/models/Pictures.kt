package com.geektech.kotlinhw3.models

import java.io.Serializable

data class Pictures(
    val url: String,
    var isSelected: Boolean
): Serializable
