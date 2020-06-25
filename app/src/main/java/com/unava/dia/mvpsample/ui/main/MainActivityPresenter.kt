package com.unava.dia.mvpsample.ui

import com.unava.dia.mvpsample.base.BasePresenter
import com.unava.dia.mvpsample.api.common.CommonGreetingUseCase
import com.unava.dia.mvpsample.lobby.LobbyGreetingUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

internal class MainActivityPresenter(
    view: MainActivityContract.MainActivityView,
    private val loadCommonGreetingUseCase: CommonGreetingUseCase,
    private val loadLobbyGreetingUseCase: LobbyGreetingUseCase
) : BasePresenter<MainActivityContract.MainActivityView>(view),
    MainActivityContract.MainActivityPresenter {

    override fun loadCommonGreeting() {
        loadGreeting(loadCommonGreetingUseCase.execute())
    }

    override fun loadLobbyGreeting() {
        loadGreeting(loadLobbyGreetingUseCase.execute())
    }

    private fun loadGreeting(greetingSingle: Single<String>) {
        addDisposable(
            greetingSingle
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::displayGreeting, view::displayGreetingError)
        )
    }
}