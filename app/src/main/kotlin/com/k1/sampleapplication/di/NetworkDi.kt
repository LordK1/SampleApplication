package com.k1.sampleapplication.di

import com.k1.sampleapplication.network.Network
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkDi {

    @Provides
    fun provideNetwork() = Network()
}