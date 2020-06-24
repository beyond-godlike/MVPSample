package com.unava.dia.mvpsample.lobby

import com.unava.dia.mvpsample.common.CommonGreetingUseCase
import dagger.Module
import dagger.Provides


@Module
class LobbyModule {

    @Provides
    internal fun provideLobbyGreetingRepository(): LobbyGreetingRepository {
        return LobbyGreetingRepository()
    }

    @Provides
    internal fun provideLobbyPresenter(
        lobbyView: LobbyGreetingContract.LobbyView,
        loadCommonGreetingUseCase: CommonGreetingUseCase,
        loadLobbyGreetingUseCase: LobbyGreetingUseCase
    ): LobbyPresenter {
        return LobbyPresenter(
            lobbyView,
            loadCommonGreetingUseCase,
            loadLobbyGreetingUseCase
        )
    }
}