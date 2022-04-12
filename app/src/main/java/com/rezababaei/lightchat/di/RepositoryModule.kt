package com.rezababaei.lightchat.di

import com.rezababaei.lightchat.network.repositories.SocketRepository
import com.rezababaei.lightchat.network.repositories.SocketRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds //for Interface
    @Singleton
    abstract fun bindSocketRepository(socketRepositoryImpl: SocketRepositoryImpl):SocketRepository
}