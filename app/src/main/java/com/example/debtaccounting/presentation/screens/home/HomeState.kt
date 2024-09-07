package com.example.debtaccounting.presentation.screens.home

import androidx.compose.runtime.mutableStateOf
import com.example.debtaccounting.data.local.room.PersonData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class HomeState (
    val personData: List<PersonData> = emptyList(),
    val cardStates: List<CardState> = emptyList()
)

data class CardState(
    val personData: PersonData,
    val isExpanded: Boolean = false
)