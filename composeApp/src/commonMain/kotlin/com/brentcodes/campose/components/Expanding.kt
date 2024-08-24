package com.brentcodes.campose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExpandingHorizontal(modifier: Modifier = Modifier) {
    val expandedIndex = mutableIntStateOf(0)
    Row {
        for (value in 0..4) {
            ExpandingHorizontalItem(expanded = expandedIndex.value == value, onClick = { expandedIndex.value = value} , index = value)
        }
    }
}

@Composable
fun ExpandingHorizontalItem(expanded: Boolean, onClick: () -> Unit, index: Int) {
    val weight by animateFloatAsState(if (expanded) 3f else 1f)
    Box() {
        Column(modifier = Modifier.background(Color.LightGray).fillMaxWidth().clickable { onClick() }.padding(20.dp)) {
            Text("This is card $index")
            Text("Card $index expanded: $expanded")
        }
    }

}