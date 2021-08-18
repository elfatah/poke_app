package com.elfatah.pokeapp

import android.app.Application
import com.elfatah.pokeapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokeApp)
            modules(
                listOf(
                    apiModule,
                    repositoryModule,
                    dataSourceModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}