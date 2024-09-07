package com.example.debtaccounting.data.local.repositorys

import android.app.Application

class PersonApplication: Application() {
    lateinit var container: PersonContainer

    override fun onCreate() {
        super.onCreate()
        container = PersonContainer(this)
    }
}