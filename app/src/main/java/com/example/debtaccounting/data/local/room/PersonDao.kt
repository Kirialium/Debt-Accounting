package com.example.debtaccounting.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Query("SELECT * FROM person_data")
    fun getAll(): Flow<List<PersonData>>

    @Insert
    suspend fun insertPerson(person: PersonData)
}