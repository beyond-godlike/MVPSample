package com.unava.dia.mvpsample.lobby

import io.reactivex.Single

class LobbyGreetingRepository {
    val greeting: Single<String>
        get() = Single.just("Hello from LobbyGreetingRepository")
}