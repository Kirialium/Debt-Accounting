package com.example.debtaccounting.data.local.models

data class PersonModel(
    val name: String = "",
    val debts: List<Int> = emptyList(),
    val debtSum: Int = 0,
    val debtStartTime: String = "",
    val debtEndTime: String = ""
)