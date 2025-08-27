package com.aarh.borutoapp.di

import androidx.paging.ExperimentalPagingApi
import com.aarh.borutoapp.data.remote.BorutoApi
import com.aarh.borutoapp.data.repository.RemoteDataSourceImpl
import com.aarh.borutoapp.util.Constants.BASE_URL
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

private val contentType = "application/json".toMediaType()

@OptIn(ExperimentalPagingApi::class)
val networkModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    single { get<Retrofit>().create(BorutoApi::class.java) }

    single {
        RemoteDataSourceImpl(
            api = get(),
            heroDao = get(),
            heroRemoteKeysDao = get()
        )
    }
}
