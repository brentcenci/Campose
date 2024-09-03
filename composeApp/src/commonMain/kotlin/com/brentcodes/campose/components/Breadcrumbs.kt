package com.brentcodes.campose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BasicBreadcrumb(modifier: Modifier = Modifier, separator: String = "»", sections: List<String> = listOf("Cart", "Billing", "Shipping", "Payment")) {
    val current = remember { mutableIntStateOf(2) }
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

/*
@Composable
fun StepsBreadcrumbNode(modifier: Modifier = Modifier, index: Int, isLast: Boolean, current: Int, circleRadius: Dp = 10.dp) {
    val textMeasurer = rememberTextMeasurer()
    Box(
        modifier = Modifier
            .wrapContentSize()
            .drawBehind {
                val color = if (index <= current) Color.Blue else Color.LightGray
                drawCircle(
                    color = color,
                    radius = circleRadius.toPx(),
                    center = Offset(circleRadius.toPx(), circleRadius.toPx())
                )
                drawText(
                    textMeasurer = textMeasurer,
                    text = AnnotatedString(index.toString()),
                    color = Color.White,
                    center = Offset(circleRadius.toPx(), circleRadius.toPx()),

                )
            }
    ) {

    }
}

@Composable
fun StepsBreadcrumb(modifier: Modifier = Modifier) {
    val sections = listOf("AYY", "BEE", "CEE", "DEE")
    Row {

    }
}*/
