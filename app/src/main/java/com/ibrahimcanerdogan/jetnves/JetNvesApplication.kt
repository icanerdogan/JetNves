package com.ibrahimcanerdogan.jetnves

import android.app.Application
import android.os.LocaleList
import com.ibrahimcanerdogan.jetnves.data.model.common.NewsCountries
import com.ibrahimcanerdogan.jetnves.data.model.common.NewsLanguages
import com.ibrahimcanerdogan.jetnves.util.Constants
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JetNvesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupLocaleCode()
    }

    private fun setupLocaleCode() {
        val userLocale = LocaleList.getDefault().get(0)
        val localeCountry = NewsCountries.entries.find {
            it.name.equals(userLocale.country, ignoreCase = true)
        }
        val localeLanguage = NewsLanguages.entries.find {
            it.name.equals(userLocale.language, ignoreCase = true)
        }

        Constants.countryCode = localeCountry?.countryCode ?: "us"
        Constants.languageCode = localeLanguage?.lanCode ?: "en"
    }
}