package com.gc.dictionaryapp.feature_dictionary.domain.model

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
)
