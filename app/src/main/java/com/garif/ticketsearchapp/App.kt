package com.garif.ticketsearchapp

import android.app.Application
import com.garif.blank_feature.di.BlankFeatureComponent
import com.garif.blank_feature.di.BlankFeatureComponentProvider
import com.garif.main_feature.di.MainFeatureComponent
import com.garif.main_feature.di.MainFeatureComponentProvider
import com.garif.selected_country_feature.di.SelectedCountryFeatureComponent
import com.garif.selected_country_feature.di.SelectedCountryFeatureComponentProvider

class App : Application(), BlankFeatureComponentProvider,
    MainFeatureComponentProvider, SelectedCountryFeatureComponentProvider {
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

    override fun getSelectedCountryFeatureComponent(): SelectedCountryFeatureComponent {
        return appComponent.createSelectedCountryComponent()
    }
}