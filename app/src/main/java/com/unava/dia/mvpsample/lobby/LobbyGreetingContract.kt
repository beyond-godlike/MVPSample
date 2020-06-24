package com.unava.dia.mvpsample.lobby

internal interface LobbyGreetingContract {

    interface LobbyView {
        fun onCommonGreetingButtonClicked()
        fun onLobbyGreetingButtonClicked()

        fun displayGreeting(greeting: String)
        fun hideGreeting()
        fun displayGreetingError(throwable: Throwable)
        fun setLoadingIndicator(active: Boolean)
    }

    interface LobbyPresenter {
        fun loadCommonGreeting()
        fun loadLobbyGreeting()
    }
}