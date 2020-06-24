package com.unava.dia.mvpsample.lobby

import dagger.Module
import dagger.Binds



@Module
abstract class LobbyViewModule {
    @Binds
    internal abstract fun provideLobbyView(lobbyActivity: LobbyActivity): LobbyGreetingContract.LobbyView
}