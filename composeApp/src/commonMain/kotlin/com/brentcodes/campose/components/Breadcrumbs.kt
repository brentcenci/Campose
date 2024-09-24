package com.brentcodes.campose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BasicBreadcrumb(
    modifier: Modifier = Modifier,
    separator: String = "»",
    sections: List<String> = listOf("Cart", "Billing", "Shipping", "Payment"),
    primaryColor: Color = Color(0xFF206FEE),
    secondaryColor: Color = Color.Gray
) {
    val current = remember { mutableIntStateOf(2) }
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        sections.forEachIndexed { index, section ->
            Text(
                text = section,
                fontWeight = if (index == current.value) FontWeight.Bold else FontWeight.Normal,
                color = if (current.value < index) secondaryColor else primaryColor,
                modifier = Modifier.clickable { current.value = index }
            )
            if (index != sections.size - 1) {
                Text(separator, color = secondaryColor)
            }
        }
    }
}

@Composable
fun BasicBreadcrumbWithIcon(
    modifier: Modifier = Modifier,
    separator: String = "»",
    sections: List<String> = listOf(
        "Home",
        "Search",
        "Cart",
        "Purchase Successful"
    ),
    icons: List<ImageVector> = listOf(
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.ShoppingCart,
        Icons.Default.ThumbUp
    ),
    primaryColor: Color = Color(0xFF206FEE),
    secondaryColor: Color = Color.Gray
) {
    val current = remember { mutableIntStateOf(2) }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (index in sections.indices) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.clickable { current.value = index }) {
                Icon(
                    icons[index],
                    "",
                    tint = if (current.value < index) secondaryColor else primaryColor,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = sections[index],
                    fontWeight = if (index == current.value) FontWeight.Bold else FontWeight.Normal,
                    color = if (current.value < index) secondaryColor else primaryColor,
                )
            }
            if (index != sections.size - 1) {
                Text(separator, color = secondaryColor)
            }
        }
    }
}

@Composable
fun BubbleBreadcrumbs(
    modifier: Modifier = Modifier,
    separator: String = "»",
    sections: List<String> = listOf(
        "Home",
        "Search",
        "Cart",
        "Purchase Successful"
    ),
    icons: List<ImageVector> = listOf(
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.ShoppingCart,
        Icons.Default.ThumbUp
    ),
    primaryColor: Color = Color(0xFF206FEE),
    secondaryColor: Color = Color.Gray

) {
    val current = remember { mutableIntStateOf(2) }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (index in sections.indices) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.background(if (current.value == index) primaryColor else Color.Transparent, RoundedCornerShape(50)).clip(
                    RoundedCornerShape(50)).clickable { current.value = index }.padding(8.dp)
            ) {
                Icon(
                    icons[index],
                    "",
                    tint = if (current.value < index) secondaryColor else if (current.value == index) Color.White else primaryColor,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = sections[index],
                    fontWeight = if (index == current.value) FontWeight.Bold else FontWeight.Normal,
                    color = if (current.value < index) secondaryColor else if (current.value == index) Color.White else primaryColor,
                )
            }
            if (index != sections.size - 1) {
                Text(separator, color = secondaryColor)
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
