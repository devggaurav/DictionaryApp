package com.gc.dictionaryapp.core.util

//
// Created by gaurav on 27/10/21.
// Copyright (c) 2021 gc. All rights reserved.
//

typealias SimpleResource = Resource<Unit>

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)

}
