package com.example.debtaccounting.presentation.components

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.debtaccounting.presentation.screens.home.TopTabsState

/*@Composable
fun TopTabs(
    tabsState: List<TopTabsState>,
    onClick: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        tabsState.forEach{topTabsState ->
            Tab(
                modifier = Modifier
                    .weight(1f),
                isSelected = topTabsState.isSelected,
                name = topTabsState.tabName,
                onClick = onClick
            )
        }
    }
}*/

@Composable
fun Tab(
    tabState: TopTabsState,
    onClick: () -> Unit,
    modifier: Modifier
){
    val tabHeight by animateDpAsState(
        targetValue = if (tabState.isSelected) 50.dp else 40.dp,
        label = ""
    )
    Card(
        modifier = modifier
            .height(tabHeight),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        border = BorderStroke(2.dp, color = Color.Black),
        shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp),
        onClick = onClick
    ){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            //TODO сменить цвет на Material theme
            Text(
                text = tabState.tabName,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}