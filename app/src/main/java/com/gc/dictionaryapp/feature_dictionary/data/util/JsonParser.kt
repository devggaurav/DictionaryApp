package com.gc.dictionaryapp.feature_dictionary.data.util

import java.lang.reflect.Type

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

interface JsonParser {

    fun <T> fromJson(json: String, type: Type): T?

    fun <T> toJson(obj: T, type: Type): String?

}