package com.example.debtaccounting.presentation.screens.home

import androidx.compose.runtime.mutableStateOf
import com.example.debtaccounting.data.local.room.PersonData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class HomeState (
    val selectedTab: Int = 0,

    val personData: List<PersonData> = emptyList(),
    val cardStates: List<CardState> = emptyList(),
    val tabsStates: List<TopTabsState> = emptyList()
)

data class CardState(
    val personData: PersonData,
    val isExpanded: Boolean = false
)

data class TopTabsState(
    val isSelected: Boolean = false,
    val index: Int = 0,
    val tabName: String = ""
)