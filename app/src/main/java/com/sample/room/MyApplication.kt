package com.sample.room

import android.app.Application

class MyApplication : Application() {
    companion object {
        private var instance: MyApplication? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}