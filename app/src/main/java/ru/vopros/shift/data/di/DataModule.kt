package ru.vopros.shift.data.di

import androidx.room.Room
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import ru.vopros.shift.data.repository.LocalUserRepositoryImpl
import ru.vopros.shift.data.repository.RemoteUserRepositoryImpl
import ru.vopros.shift.data.retrofit.UserApi
import ru.vopros.shift.data.room.AppDatabase
import ru.vopros.shift.domain.Constants
import ru.vopros.shift.domain.Constants.APPLICATION_JSON
import ru.vopros.shift.domain.repository.LocalUserRepository
import ru.vopros.shift.domain.repository.RemoteUserRepository

private val retrofit = module {
    single<Json> {
        Json {
            ignoreUnknownKeys = true
            prettyPrint = true
        }
    }
    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(get())
            .addConverterFactory(
                get<Json>().asConverterFactory(
                    APPLICATION_JSON.toMediaType()
                )
            )
            .build()
    }
    single<UserApi> {
        get<Retrofit>().create(UserApi::class.java)
    }
}

private val room = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = AppDatabase::class.java,
            name = AppDatabase.NAME
        ).build()
    }
}

private val repository = module {
    singleOf(::RemoteUserRepositoryImpl) { bind<RemoteUserRepository>() }
    singleOf(::LocalUserRepositoryImpl) { bind<LocalUserRepository>() }
}

internal val dataModule = module {
    includes(
        retrofit,
        room,
        repository
    )
}