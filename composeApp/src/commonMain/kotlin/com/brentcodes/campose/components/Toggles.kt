package com.brentcodes.campose.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainToggle(modifier: Modifier = Modifier) {
    val checked = remember { mutableStateOf(false) }
    Column {
        IconToggleButton(checked = checked.value, onCheckedChange = { checked.value = !checked.value }) {
            Icon(Icons.Default.Home, "Home Icon")
        }
        Switch(checked = checked.value, onCheckedChange = { checked.value = !checked.value })
        CustomToggle(state = checked.value, onCheckedChange = {checked.value = !checked.value})
    }
}

@Composable
fun CustomToggle(state: Boolean, onCheckedChange: () -> Unit = {}) {
    val color by animateColorAsState(if (!state) Color.White else Color.Blue)
    val weightOne by animateFloatAsState(if (!state) 0.1f else 1f)
    val weightTwo by animateFloatAsState(if (state) 0.1f else 1f)
    Box(modifier = Modifier.size(50.dp, 26.dp).background(color, RoundedCornerShape(50)).clickable { onCheckedChange() }, contentAlignment = Alignment.Center)  {
        Row {
            Spacer(modifier = Modifier.weight(weightOne))
            Box(modifier = Modifier.size(20.dp).background(Color.LightGray, RoundedCornerShape(50)))
            Spacer(modifier = Modifier.weight(weightTwo))
        }

    }
}