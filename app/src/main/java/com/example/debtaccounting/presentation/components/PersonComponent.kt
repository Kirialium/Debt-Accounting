package com.example.debtaccounting.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.debtaccounting.presentation.screens.home.CardState
import com.example.debtaccounting.presentation.screens.home.HomeViewModel

@Composable
fun PersonComponent(
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory),
    cardState: CardState,
    onClick: () -> Unit
){
    val state by viewModel.homeState.collectAsState()
    val cardHeightValue by animateDpAsState(
        targetValue = if (cardState.isExpanded) 200.dp else 70.dp,
        label = ""
    )
    val cardElevationValue by animateDpAsState(
        targetValue = if (cardState.isExpanded) 7.dp else 3.dp,
        label = ""
    )

    Card(
        shape = RoundedCornerShape(2.dp),
        modifier = Modifier
            .padding(all = 20.dp)
            .fillMaxWidth()
            .height(cardHeightValue)
            .shadow(
                elevation = cardElevationValue,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
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
    }
}