package com.gc.dictionaryapp.feature_dictionary.data.util


import com.google.gson.Gson
import java.lang.reflect.Type

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

class GsonParser(private val gson: Gson) : JsonParser {


    override fun <T> fromJson(json: String, type: Type): T? {
        return gson.fromJson(json, type)
    }

    override fun <T> toJson(obj: T, type: Type): String? {
        return gson.toJson(obj, type)
    }
}