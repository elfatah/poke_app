package com.elfatah.pokeapp.util

sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    class Error<T>(val error: Throwable) : Resource<T>()
    class Success<T>(val data: T) : Resource<T>()
}