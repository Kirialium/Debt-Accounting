package com.example.debtaccounting.data.local.repositorys

import android.content.Context
import com.example.debtaccounting.data.local.room.PersonDatabase

class PersonContainer(private val context: Context) {
    val personRepository: PersonRepository by lazy {
        PersonRepository(PersonDatabase.getPersonsDatabase(context).personsDao())
    }
}