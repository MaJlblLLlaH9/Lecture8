package com.example.lecture8

import android.content.Context
import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes stringResId: Int): String
}

class BaseResourceManager(private val context: Context): ResourceManager{
    override fun getString(stringResId: Int) = context.getString(stringResId)
}
