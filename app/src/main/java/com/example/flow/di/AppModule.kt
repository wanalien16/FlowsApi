package com.example.flow.di

import android.content.Context
import androidx.room.Room
import com.example.flow.data.local.AppDatabase
import com.example.flow.data.local.NotesDao
import com.example.flow.data.remote.ApiService
import com.example.flow.data.repository.JokeRepoImpl
import com.example.flow.domain.repository.JokeRepo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://api.chucknorris.io/"
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    @Provides
    @Singleton
    fun provideJokeRepository(apiService: ApiService): JokeRepo {
        return JokeRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabaseInstance(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "App Database").build()
    }

    @Provides
    @Singleton
    fun provideDeveloperDao(database: AppDatabase): NotesDao {
        return database.notesDao()
    }



}