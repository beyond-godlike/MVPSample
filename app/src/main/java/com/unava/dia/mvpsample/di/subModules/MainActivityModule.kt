package com.unava.dia.mvpsample.lobby

import com.unava.dia.mvpsample.common.CommonGreetingUseCase
import com.unava.dia.mvpsample.ui.MainActivityContract
import com.unava.dia.mvpsample.ui.MainActivityPresenter
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    //@Provides
    //internal fun provideLobbyGreetingRepository(): LobbyGreetingRepository {
    //    return LobbyGreetingRepository()
    //}

    @Provides
    internal fun provideMainActivityPresenter(
        mainView: MainActivityContract.MainActivityView,
        loadCommonGreetingUseCase: CommonGreetingUseCase,
        loadLobbyGreetingUseCase: LobbyGreetingUseCase
    ): MainActivityPresenter {
        return MainActivityPresenter(
            mainView,
            loadCommonGreetingUseCase,
            loadLobbyGreetingUseCase
        )
    }
}