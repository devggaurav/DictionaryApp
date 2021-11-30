package com.gc.dictionaryapp.feature_dictionary.domain.model

import com.gc.dictionaryapp.feature_dictionary.data.remote.dto.MeaningDto
import com.gc.dictionaryapp.feature_dictionary.data.remote.dto.PhoneticDto

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)
