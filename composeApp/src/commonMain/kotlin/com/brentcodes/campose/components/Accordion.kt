package com.brentcodes.campose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BasicAccordion(modifier: Modifier = Modifier, title: String = "Title Goes Here", content: String = "Lorem ipsum odor amet, consectetuer adipiscing elit. Finibus semper libero posuere vel ex volutpat mattis fusce laoreet. " +
        "Euismod ex ridiculus suspendisse euismod viverra. Congue non auctor blandit a habitant primis suspendisse vulputate. " +
        "Magnis parturient neque aliquet habitant praesent metus rhoncus. Massa parturient dis posuere malesuada ipsum nam feugiat varius. " +
        "Id senectus aenean dis fames lobortis dui nunc.\n" + "\n" + "Sodales interdum ultricies morbi litora placerat curae. " +
        "Netus libero suscipit facilisis egestas praesent. Interdum condimentum egestas dolor adipiscing suscipit suscipit tempor dis. " +
        "Vestibulum ex conubia netus ut ipsum platea; congue euismod tellus. Per natoque nostra vulputate suspendisse blandit elit curae. " +
        "Lacinia tincidunt semper montes volutpat posuere habitasse. Cursus ac montes integer; rhoncus ultrices donec sodales. " +
        "Non tortor feugiat blandit posuere fringilla finibus parturient euismod lectus.") {
    val openState = remember { mutableStateOf(false) }
    val degrees = animateFloatAsState(if (openState.value) 180f else 0f)
    Column(
        modifier = modifier.padding(10.dp).clip(RoundedCornerShape(20.dp)).background(Color.White)
            .clickable { openState.value = !openState.value }.padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Icon(
                Icons.Default.ArrowDropDown,
                "Description Here",
                modifier = Modifier.rotate(degrees.value).size(48.dp)
            )
        }
        AnimatedVisibility(visible = openState.value) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                HorizontalDivider(modifier = Modifier.fillMaxWidth())
                Text(
                    content,
                    fontSize = 20.sp
                )
            }

        }


    }
}