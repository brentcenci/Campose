package com.brentcodes.campose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicMusicControls(modifier: Modifier = Modifier) {
    var sliderValue by remember { mutableStateOf(0f) }
    val sliderState = remember { SliderState(value = sliderValue) }
    Column(modifier = modifier.width(300.dp)) {
        Column {
            Slider(value = sliderValue, onValueChange = { sliderValue = it}, modifier = Modifier.fillMaxWidth())
            Slider(state = sliderState, modifier = Modifier.fillMaxWidth(), thumb = { Box(modifier = Modifier.size(30.dp).background(Color.Green, RoundedCornerShape(50)).clip(RoundedCornerShape(50)))})
        } //Slider
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = {}) {
                Icon(Icons.Default.KeyboardArrowLeft, "Back")
            }
            IconButton(
                onClick = {},
                colors = IconButtonDefaults.filledIconButtonColors()) {
                Icon(Icons.Default.PlayArrow, "Play")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.KeyboardArrowRight, "Forward")
            }
        } //Buttons
    }
}