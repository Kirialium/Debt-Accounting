package com.example.debtaccounting.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonData::class], version = 1)
abstract class PersonDatabase: RoomDatabase() {
    abstract fun personsDao(): PersonDao

    companion object{
        @Volatile
        private var Instance: PersonDatabase? = null

        fun getPersonsDatabase(context: Context): PersonDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context = context,
                    klass = PersonDatabase::class.java,
                    name = "person_data"
                )
                    .build()
                    .also { Instance = it }
            }
        }
    }
}