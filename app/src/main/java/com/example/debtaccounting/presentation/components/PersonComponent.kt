package com.example.debtaccounting.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.debtaccounting.R
import com.example.debtaccounting.presentation.screens.home.CardState
import com.example.debtaccounting.presentation.screens.home.HomeViewModel

@Composable
fun PersonComponent(
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory),
    cardState: CardState,
    onClick: () -> Unit
){
    val state by viewModel.homeState.collectAsState()
    val cardHeight by animateDpAsState(targetValue = if (cardState.isExpanded) 200.dp else 70.dp)
    Card(
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 20.dp)
            .fillMaxWidth()
            .height(cardHeight),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        onClick = onClick
    ){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ){
            Text(
                text = cardState.personData.name,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
        val offsetY by animateFloatAsState(targetValue = if(cardState.isExpanded) 30f else 0f)
        val textModifier = Modifier
        Text(
            text = "Всего: ${cardState.personData.debtSum}₽",
            modifier = Modifier
        )
    }
}