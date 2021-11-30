package com.gc.dictionaryapp.feature_dictionary.domain.model

import com.gc.dictionaryapp.feature_dictionary.data.remote.dto.DefinitionDto

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

data class Meaning(val definitions: List<Definition>,
                   val partOfSpeech: String)
