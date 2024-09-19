package com.brentcodes.campose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BasicMusicControls(modifier: Modifier = Modifier) {
    Column(modifier = modifier.width(300.dp)) {
        Row {
            Box(modifier = Modifier.fillMaxWidth().height(10.dp).background(Color.LightGray, RoundedCornerShape(50))) {  }
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