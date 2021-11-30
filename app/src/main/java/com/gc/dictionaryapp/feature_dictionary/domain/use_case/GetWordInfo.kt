package com.gc.dictionaryapp.feature_dictionary.domain.use_case

import com.gc.dictionaryapp.core.util.Resource
import com.gc.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.gc.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

class GetWordInfo(

    private val repository: WordInfoRepository
) {


    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {

        if (word.isBlank()) {
            return flow { }
        }
        return repository.getWordInfo(word)
    }
}