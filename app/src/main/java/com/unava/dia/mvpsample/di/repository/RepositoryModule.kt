package com.unava.dia.mvpsample.di.repository

import com.unava.dia.mvpsample.common.CommonGreetingRepository
import com.unava.dia.mvpsample.lobby.LobbyGreetingRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideCommonGreetingRepository(): CommonGreetingRepository {
        return CommonGreetingRepository()
    }

    @Singleton
    @Provides
    fun provideLobbyGreetingRepository() : LobbyGreetingRepository {
        return LobbyGreetingRepository()
    }
}