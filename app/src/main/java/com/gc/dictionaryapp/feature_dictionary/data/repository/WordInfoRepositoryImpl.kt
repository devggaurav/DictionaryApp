package com.gc.dictionaryapp.feature_dictionary.data.repository

import com.gc.dictionaryapp.core.util.Resource
import com.gc.dictionaryapp.feature_dictionary.data.local.WordInfoDao
import com.gc.dictionaryapp.feature_dictionary.data.remote.DictionaryApi
import com.gc.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.gc.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao


) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })


        } catch (ex: HttpException) {
            emit(
                Resource.Error(
                    message = "Something went wrong!",
                    data = wordInfos
                )
            )

        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "could not reach server, check your internet connection.",
                    data = wordInfos
                )
            )

        }

        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfos))

    }


}