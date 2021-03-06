/**
 * Copyright (C) 2017 Cesar Valiente & Corey Shaw
 *
 * https://github.com/CesarValiente
 * https://github.com/coshaw
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cesarvaliente.kunidirectional

import android.app.Application
import android.preference.PreferenceManager
import com.cesarvaliente.kunidirectional.persistence.setupPersistence

class ItemsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        storeInitialization()
    }

    private fun storeInitialization() {
        if (isPersistenceEnabled()) {
            AppStore.enablePersistence()
            setupPersistence(context = this)
        }
    }

    private fun isPersistenceEnabled(): Boolean {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        return sharedPreferences.getBoolean(getString(R.string.pref_persistence_key), true)
    }
}
