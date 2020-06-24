package com.unava.dia.mvpsample.di

import com.unava.dia.mvpsample.lobby.LobbyActivity
import com.unava.dia.mvpsample.lobby.LobbyModule
import com.unava.dia.mvpsample.lobby.LobbyViewModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [
        LobbyViewModule::class,
        LobbyModule::class
    ])
    internal abstract fun bindLobbyActivity(): LobbyActivity
}