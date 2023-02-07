package com.example.tasky.util

sealed class Resource<T> (
        val data: T? = null,
        val error: Throwable? = null
){
    class Sucess<T>(data: T): Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(throwable: Throwable,data: T? = null) : Resource<T>(data, throwable)

}