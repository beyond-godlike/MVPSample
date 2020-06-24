package com.unava.dia.mvpsample.lobby

import io.reactivex.Single
import javax.inject.Inject

class LobbyGreetingUseCase @Inject constructor(private var lobbyRepository: LobbyGreetingRepository) {
    fun execute() : Single<String> {
        return lobbyRepository.greeting
    }
}