package com.unava.dia.mvpsample.lobby

import com.unava.dia.mvpsample.ui.MainActivity
import com.unava.dia.mvpsample.ui.MainActivityContract
import dagger.Module
import dagger.Binds



@Module
abstract class MainActivityViewModule {
    @Binds
    internal abstract fun provideMainActivityView(mainActivity: MainActivity): MainActivityContract.MainActivityView
}