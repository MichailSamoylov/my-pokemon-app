package com.app.mypokemonapp

import android.app.Application
import com.app.mypokemonapp.di.appModule
import com.app.mypokemonapp.di.navigateModule
import com.app.mypokemonapp.screens.startscreen.di.startScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin {
			androidLogger(Level.ERROR)
			androidContext(this@App)

			modules(
				appModule,
				navigateModule,
				startScreenModule
			)
		}
	}
}