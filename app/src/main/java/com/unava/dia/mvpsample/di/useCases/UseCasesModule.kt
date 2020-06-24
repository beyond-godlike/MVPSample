package com.unava.dia.mvpsample.di.useCases

import com.unava.dia.mvpsample.common.CommonGreetingRepository
import com.unava.dia.mvpsample.lobby.LobbyGreetingUseCase
import com.unava.dia.mvpsample.common.CommonGreetingUseCase
import com.unava.dia.mvpsample.lobby.LobbyGreetingRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCasesModule {
    @Singleton
    @Provides
    fun provideCommonGreetingUseCase(greetingRepository: CommonGreetingRepository): CommonGreetingUseCase {
        return CommonGreetingUseCase(greetingRepository)
    }

    @Singleton
    @Provides
    fun provideLobbyGreetingUseCase(lobbyRepository: LobbyGreetingRepository) : LobbyGreetingUseCase {
        return LobbyGreetingUseCase(lobbyRepository)
    }
}