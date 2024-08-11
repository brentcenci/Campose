package com.brentcodes.campose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.AsyncImage

@Composable
fun Card(modifier: Modifier = Modifier, title: String, content: String) {
    Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).width(300.dp).padding(20.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(text = title, fontSize = 28.sp, color = Color.DarkGray, fontWeight = FontWeight.Bold)
            Text(text = content, color = Color.DarkGray)
        }
    }
}

@Composable
fun ImageCard(title: String, content: String, imageUrl: String) {
    Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).width(300.dp).padding(20.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Placeholder",
                imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = title, fontSize = 28.sp, color = Color.DarkGray, fontWeight = FontWeight.Bold)
            Text(text = content, color = Color.DarkGray)
        }
    }
}

@Composable
fun ImageCardWithButton(title: String, content: String, imageUrl: String, buttonText: String) {
    Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).width(300.dp).padding(20.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Placeholder",
                imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = title, fontSize = 28.sp, color = Color.DarkGray, fontWeight = FontWeight.Bold)
            Text(text = content, color = Color.DarkGray)
            Button( onClick = {}, modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp), shape = RoundedCornerShape(10.dp)) {
                Text(text = buttonText)
            }
        }
    }
}

@Composable
fun ImageCardWithBadges(title: String, content: String, imageUrl: String, titleBadge: String, contentBadges: List<String>) {
    Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).width(300.dp).padding(20.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Placeholder",
                imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = title, fontSize = 28.sp, color = Color.DarkGray, fontWeight = FontWeight.Bold)
                Box(modifier = Modifier.border(width = 2.dp, Color.Red, RoundedCornerShape(50)).padding(horizontal = 6.dp, vertical = 4.dp)) {
                    Text(text = titleBadge, color = Color.Red, fontSize = 16.sp)
                }
            }
            Text(text = content, color = Color.DarkGray)
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.padding(top = 16.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                contentBadges.forEach {
                    Box(modifier = Modifier.background(Color.hsl(267F, 1f, 0.4f), RoundedCornerShape(50)).padding(4.dp)){
                        Text(text = it, color = Color.White)
                    }
                }
            }
        }
    }
}