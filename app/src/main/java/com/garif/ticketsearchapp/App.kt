package com.garif.ticketsearchapp

import android.app.Application
import com.garif.ticketsearchapp.di.BlankFeatureComponent
import com.garif.ticketsearchapp.di.BlankFeatureComponentProvider
import com.garif.ticketsearchapp.di.MainFeatureComponent
import com.garif.ticketsearchapp.di.MainFeatureComponentProvider

class App : Application(), BlankFeatureComponentProvider, MainFeatureComponentProvider {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }

    override fun getBlankFeatureComponent(): BlankFeatureComponent {
        return appComponent.createBlankComponent()
    }

    override fun getMainFeatureComponent(): MainFeatureComponent {
        return appComponent.createMainComponent()
    }
}