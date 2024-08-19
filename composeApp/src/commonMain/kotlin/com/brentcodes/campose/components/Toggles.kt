package com.brentcodes.campose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun MainToggle(modifier: Modifier = Modifier) {
    val checked = remember { mutableStateOf(false) }
    Column {
        IconToggleButton(checked = checked.value, onCheckedChange = { checked.value = !checked.value }) {
            Icon(Icons.Default.Home, "Home Icon")
        }
        Switch(checked = checked.value, onCheckedChange = { checked.value = !checked.value })
    }

}