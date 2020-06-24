package com.unava.dia.mvpsample.lobby

import com.unava.dia.mvpsample.base.BasePresenter
import com.unava.dia.mvpsample.common.CommonGreetingUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

internal class LobbyPresenter(
    view: LobbyGreetingContract.LobbyView,
    private val loadCommonGreetingUseCase: CommonGreetingUseCase,
    private val loadLobbyGreetingUseCase: LobbyGreetingUseCase
) : BasePresenter<LobbyGreetingContract.LobbyView>(view), LobbyGreetingContract.LobbyPresenter {

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