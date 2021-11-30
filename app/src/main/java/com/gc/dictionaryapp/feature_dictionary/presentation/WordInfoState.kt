package com.gc.dictionaryapp.feature_dictionary.presentation

import com.gc.dictionaryapp.feature_dictionary.domain.model.WordInfo

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
