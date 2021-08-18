package com.elfatah.pokeapp.di

import android.content.Context
import com.elfatah.pokeapp.BuildConfig
import com.elfatah.pokeapp.data.api.PokeApi
import com.elfatah.pokeapp.domain.pokemon.model.ApiResource
import com.elfatah.pokeapp.domain.pokemon.model.NamedApiResource
import com.elfatah.pokeapp.util.ApiResourceAdapter
import com.elfatah.pokeapp.util.NamedApiResourceAdapter
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    single { makeOkHttpClient(get(), get()) }
    single { makeChuckInterceptor(context = androidContext()) }
    single {
        makeRetrofit(
            baseUrl = BuildConfig.BASE_URL,
            client = get(),
            converterFactory = get()
        )
    }
    single { makeConverterFactory() }
    single { makePokeApi(get()) }
    single { makeLoggingInterceptor() }
}

private fun makePokeApi(retrofit: Retrofit): PokeApi =
    retrofit.create(PokeApi::class.java)

private fun makeRetrofit(
    baseUrl: String,
    client: OkHttpClient,
    converterFactory: GsonConverterFactory
): Retrofit {

    return Retrofit.Builder()
        .addConverterFactory(converterFactory)
        .baseUrl(baseUrl)
        .client(client)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

}

private fun makeConverterFactory(): GsonConverterFactory {
    return GsonConverterFactory.create(
        GsonBuilder().apply {
            setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            registerTypeAdapter(
                TypeToken.get(ApiResource::class.java).type,
                ApiResourceAdapter()
            )
            registerTypeAdapter(
                TypeToken.get(NamedApiResource::class.java).type,
                NamedApiResourceAdapter()
            )
        }.create()
    )
}

private fun makeOkHttpClient(
    chuckInterceptor: ChuckInterceptor,
    httpLoggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {

    val builder = OkHttpClient.Builder()
        .readTimeout(30L, TimeUnit.SECONDS)
        .connectTimeout(30L, TimeUnit.SECONDS)
        .writeTimeout(30L, TimeUnit.SECONDS)
        .addInterceptor(chuckInterceptor)
        .addInterceptor(httpLoggingInterceptor)


    return builder.build()
}

private fun makeChuckInterceptor(context: Context): ChuckInterceptor {
    return ChuckInterceptor(context)
}

private fun makeLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
}