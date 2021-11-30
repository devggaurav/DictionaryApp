package com.gc.dictionaryapp.feature_dictionary.data.remote

import com.gc.dictionaryapp.feature_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

interface DictionaryApi {


    @GET("api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ) : List<WordInfoDto>

    companion object{
        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }

}