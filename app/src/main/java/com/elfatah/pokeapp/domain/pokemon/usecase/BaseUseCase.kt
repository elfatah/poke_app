package com.elfatah.pokeapp.domain.pokemon.usecase

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseUseCase<I, O> {

    fun execute(params: I): Observable<O> {
        return runCatching {
            build(params).subscribeOn(Schedulers.io())
        }.getOrElse { Observable.error(it) }
    }

    protected abstract fun build(params: I): Observable<O>
}