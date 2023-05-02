package com.example.searchapponboardingassignment.di

import com.example.searchapponboardingassignment.data.network.NetworkClient
import com.example.searchapponboardingassignment.data.network.SearchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideSearchAPI(): SearchService {
        val retrofit = NetworkClient.provideRetrofitInstance()
        return NetworkClient.provideAPIService(retrofit)
    }
}