package com.unava.dia.mvpsample.common

import io.reactivex.Single
import javax.inject.Inject

class CommonGreetingUseCase @Inject constructor(private var greetingRepository: CommonGreetingRepository) {
    fun execute() : Single<String> {
        return greetingRepository.greeting
    }
}