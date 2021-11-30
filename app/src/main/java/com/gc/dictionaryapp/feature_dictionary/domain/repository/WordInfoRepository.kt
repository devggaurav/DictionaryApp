package com.gc.dictionaryapp.feature_dictionary.domain.repository

import com.gc.dictionaryapp.core.util.Resource
import com.gc.dictionaryapp.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

interface WordInfoRepository {


    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>

}