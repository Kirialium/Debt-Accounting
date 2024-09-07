package com.example.debtaccounting.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.TypeConverter
import com.example.debtaccounting.data.local.repositorys.PersonApplication
import com.example.debtaccounting.data.local.repositorys.PersonRepository
import com.example.debtaccounting.data.local.room.PersonData
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val personRepository: PersonRepository): ViewModel() {
    private val TAG: String = "TAG"
    private val _homeState = MutableStateFlow(HomeState())
    private val moshi = Moshi.Builder().add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory()).build()
    private val type = Types.newParameterizedType(List::class.java, Int::class.javaObjectType)
    private val adapter = moshi.adapter<List<Int>>(type)
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    init{
        getAll()
    }

    fun toggleCardExpansion(index: Int) {
        _homeState.value = _homeState.value.copy(
            cardStates = _homeState.value.cardStates.mapIndexed { i, cardState ->
                if (i == index) {
                    cardState.copy(isExpanded = !cardState.isExpanded) // Переключаем состояние для конкретной карточки
                } else {
                    cardState // Оставляем состояние для всех других карточек без изменений
                }
            }
        )
    }

    private fun getAll() {
        viewModelScope.launch {
            personRepository.getAll().collect { personDataList ->
                val cardStates = personDataList.map { personData ->
                    CardState(personData = personData, isExpanded = false)
                }
                _homeState.value = HomeState(personData = personDataList, cardStates = cardStates)
            }
        }
    }

    private fun insertPerson() = viewModelScope.launch {
        personRepository.insertPerson(
            PersonData(
                name = "Stew",
                debts = fromDebtsList(listOf(100, 200, 600)),
                debtSum = 900,
                debtStartTime = "fhsdjk",
                debtEndTime = "fhsdjk"
        ))
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PersonApplication)
                HomeViewModel(application.container.personRepository)
            }
        }
    }

    @TypeConverter
    fun fromDebtsList(debts: List<Int>): String {
        return adapter.toJson(debts) ?: "[]"
    }

    @TypeConverter
    fun toDebtsList(debts: String): List<Int> {
        return adapter.fromJson(debts) ?: emptyList()
    }
}