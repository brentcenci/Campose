package com.brentcodes.campose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BasicBreadcrumb(modifier: Modifier = Modifier, separator: String = ">") {
    val sections = listOf("Cart", "Billing", "Shipping", "Payment")
    val current = remember { mutableIntStateOf(3) }
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        sections.forEachIndexed { index, section ->
            Text(
                text = section,
                fontWeight = if (index == current.value) FontWeight.Bold else FontWeight.Normal,
                color = if (current.value < index) Color.LightGray else Color.Blue,
                modifier = Modifier.clickable { current.value = index }
            )
            if (index != sections.size-1) {
                Text(separator, color = Color.LightGray)
            }
        }
    }
}