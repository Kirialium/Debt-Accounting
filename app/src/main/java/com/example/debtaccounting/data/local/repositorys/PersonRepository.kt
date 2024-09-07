package com.example.debtaccounting.data.local.repositorys

import com.example.debtaccounting.data.local.room.PersonDao
import com.example.debtaccounting.data.local.room.PersonData

class PersonRepository(private val personDao: PersonDao) {
    fun getAll() = personDao.getAll()

    suspend fun insertPerson(personData: PersonData)
    = personDao.insertPerson(personData)
}