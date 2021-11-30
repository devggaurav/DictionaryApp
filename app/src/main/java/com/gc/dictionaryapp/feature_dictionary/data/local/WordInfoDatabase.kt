package com.gc.dictionaryapp.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gc.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity

//
// Created by gaurav on 29/11/21.
// Copyright (c) 2021 gc. All rights reserved.
//

@Database(
    entities = [WordInfoEntity::class],
    version = 1

)

@TypeConverters(Converters::class)
abstract class WordInfoDatabase : RoomDatabase() {

    abstract val dao: WordInfoDao

}