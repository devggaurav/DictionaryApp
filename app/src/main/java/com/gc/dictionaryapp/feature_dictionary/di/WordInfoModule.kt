package com.gc.dictionaryapp.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.gc.dictionaryapp.feature_dictionary.data.local.Converters
import com.gc.dictionaryapp.feature_dictionary.data.local.WordInfoDao
import com.gc.dictionaryapp.feature_dictionary.data.local.WordInfoDatabase
import com.gc.dictionaryapp.feature_dictionary.data.remote.DictionaryApi
import com.gc.dictionaryapp.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.gc.dictionaryapp.feature_dictionary.data.util.GsonParser
import com.gc.dictionaryapp.feature_dictionary.domain.repository.WordInfoRepository
import com.gc.dictionaryapp.feature_dictionary.domain.use_case.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {


    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }


    @Provides
    @Singleton
    fun provideWordInfoRepository(db: WordInfoDatabase, api: DictionaryApi): WordInfoRepository {

        return WordInfoRepositoryImpl(api, db.dao)
    }


    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {

        return Room.databaseBuilder(app, WordInfoDatabase::class.java, "word_db").addTypeConverter(
            Converters(
                GsonParser(
                    Gson()
                )
            )
        ).build()
    }


    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder().baseUrl(DictionaryApi.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(DictionaryApi::class.java)
    }

}