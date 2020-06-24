package com.unava.dia.mvpsample.common

import io.reactivex.Single

class CommonGreetingRepository {
    val greeting: Single<String>
        get() = Single.just("Hello from CommonGreetingRepository")
}