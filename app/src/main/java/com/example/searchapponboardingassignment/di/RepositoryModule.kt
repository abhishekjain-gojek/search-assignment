package com.example.searchapponboardingassignment.di

import com.example.searchapponboardingassignment.data.SearchRepository
import com.example.searchapponboardingassignment.data.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSearchRepository(searchRepository: SearchRepositoryImpl): SearchRepository

}