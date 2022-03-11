package com.example.digiturkmovie.di

import com.example.digiturkmovie.api.APIService
import com.example.digiturkmovie.helper.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl()= Constants.BASE_URL
    fun provideGenreUrl()= Constants.GENRE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL:String):APIService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)



}