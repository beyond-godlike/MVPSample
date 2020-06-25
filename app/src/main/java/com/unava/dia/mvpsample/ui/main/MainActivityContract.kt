package com.unava.dia.mvpsample.ui

internal interface MainActivityContract {

    interface MainActivityView {
        fun onCommonGreetingButtonClicked()
        fun onLobbyGreetingButtonClicked()

        fun displayGreeting(greeting: String)
        fun hideGreeting()
        fun displayGreetingError(throwable: Throwable)
        fun setLoadingIndicator(active: Boolean)
    }

    interface MainActivityPresenter {
        fun loadCommonGreeting()
        fun loadLobbyGreeting()
    }
}