package com.example.debtaccounting.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.debtaccounting.presentation.screens.home.TopTabsState
import com.example.debtaccounting.ui.theme.darkWhite
import com.example.debtaccounting.ui.theme.primaryDark

@Composable
fun Tab(
    tabState: TopTabsState,
    onClick: () -> Unit,
    modifier: Modifier
){
    val tabHeightValue by animateDpAsState(
        targetValue = if (tabState.isSelected) 50.dp else 40.dp,
        label = ""
    )
    val tabShape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
    val tabColor by animateColorAsState(
        targetValue = if(tabState.isSelected){
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.primary.copy(alpha = 0.9f)
        },
        label = ""
    )
    val tabTextColor by animateColorAsState(
        targetValue = if(tabState.isSelected){
            Color.White
        } else {
            darkWhite
        },
        label = ""
    )

    Card(
        modifier = modifier
            .height(tabHeightValue)
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
        colors = CardDefaults.cardColors(
            containerColor = tabColor
        ),
        shape = tabShape,
    ){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            //TODO сменить цвет на Material theme
            Text(
                text = tabState.tabName,
                fontSize = 16.sp,
                color = tabTextColor
            )
        }
    }
}