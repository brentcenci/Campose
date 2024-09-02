package com.brentcodes.campose.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import kotlin.math.roundToInt

@Composable
fun MainToggle(modifier: Modifier = Modifier) {
    val checked = remember { mutableStateOf(false) }
    Column {
        IconToggleButton(checked = checked.value, onCheckedChange = { checked.value = !checked.value }) {
            Icon(Icons.Default.Home, "Home Icon")
        }
        Switch(checked = checked.value, onCheckedChange = { checked.value = !checked.value })
        CustomToggle(state = checked.value, onCheckedChange = {checked.value = !checked.value})
        CustomizedSwitch(checked = checked.value, onCheckedChange = {checked.value = !checked.value})
        NewCustomToggle(state = checked.value, onCheckedChange = { checked.value = !checked.value })
    }
}

@Composable
fun NewCustomToggle(modifier: Modifier = Modifier, height: Int = 70, width: Int = 140, state: Boolean, onCheckedChange: () -> Unit = {}) {

    val color by animateColorAsState(if (!state) Color.LightGray else Color(0xFF15d137))
    val thumbColor by animateColorAsState(if (!state) Color.DarkGray else Color.White)
    val border by animateColorAsState(if (!state) Color.DarkGray else Color.Transparent)

    val sizePx = with(LocalDensity.current) { (width - height).toDp().toPx() }
    val offset = animateIntOffsetAsState(IntOffset(x = if (!state) 0 else sizePx.roundToInt(), 0)).value

    Row(
        modifier = modifier
            .height(height.dp)
            .width(width.dp)
            .clip(RoundedCornerShape(height.dp))
            .background(color)
            .border(2.dp, border, RoundedCornerShape(height.dp))
            .clickable {
                onCheckedChange()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .offset { offset }
                .size(height.dp)
                .clip(RoundedCornerShape(50))
                .background(thumbColor)
        ) {}
    }
}


@Composable
fun CustomToggle(state: Boolean, onCheckedChange: () -> Unit = {}) {
    val color by animateColorAsState(if (!state) Color.LightGray else Color.Blue)
    val thumbColor by animateColorAsState(if (!state) Color.DarkGray else Color.White)
    val border by animateColorAsState(if (!state) Color.DarkGray else Color.Transparent)
    val weightOne by animateFloatAsState(if (!state) 0.1f else 1f)
    val weightTwo by animateFloatAsState(if (state) 0.1f else 1f)
    Box(modifier = Modifier.clickable { onCheckedChange() }, contentAlignment = Alignment.Center)  {
        Box(modifier = Modifier.size(50.dp, 26.dp).background(color, RoundedCornerShape(50)).border(2.dp, border, RoundedCornerShape(50)))
        Row(modifier = Modifier.width(50.dp)) {
            Spacer(modifier = Modifier.weight(weightOne))
            Box(modifier = Modifier.size(20.dp).background(thumbColor, RoundedCornerShape(50)))
            Spacer(modifier = Modifier.weight(weightTwo))
        }
    }
}

@Composable
fun CustomizedSwitch(checked: Boolean, onCheckedChange: () -> Unit) {
    val text = if (checked) "ON" else "OFF"
    Switch(checked = checked, onCheckedChange = { onCheckedChange() }, thumbContent = { Text(text, fontSize = 11.sp) } )
}
