package com.example.debtaccounting.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.debtaccounting.presentation.components.PersonComponent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.debtaccounting.presentation.components.Tab

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
){
    val state by viewModel.homeState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Вкладки
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            state.tabsStates.forEachIndexed{index, topTabState ->
                Tab(
                    modifier = Modifier
                        .offset(y = -(2.dp))
                        .weight(1f),
                    onClick = { viewModel.changeOpenTab(index) },
                    tabState = topTabState
                )
            }
        }
        when(state.selectedTab){
            0 -> FirstScreen()
            1 -> SecondScreen()
        }
    }
}

@Composable
fun FirstScreen(viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)){
    val state by viewModel.homeState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.TopCenter
        ){
            LazyColumn {
                items(state.cardStates.size){index ->
                    val cardState = state.cardStates[index]
                    PersonComponent(cardState = cardState, onClick = {viewModel.toggleCardExpansion(index)})
                }
            }
        }
    }
}

@Composable
fun SecondScreen(viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){

    }
}