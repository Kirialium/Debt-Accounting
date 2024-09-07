package com.example.debtaccounting.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_data")
data class PersonData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val debts: String = "",
    val debtSum: Int = 0,
    val debtStartTime: String = "",
    val debtEndTime: String = ""
)