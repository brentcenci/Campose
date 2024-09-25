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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import campose.composeapp.generated.resources.Res
import campose.composeapp.generated.resources.alert_triangle
import campose.composeapp.generated.resources.app
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.AsyncImage
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun Card(modifier: Modifier = Modifier, title: String, content: String) {
    Column(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).width(300.dp)
        .padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text(
            text = title,
            fontSize = 20.sp,
        )
        Text(text = content, color = Color(0xFF6b6b6b))
    }
}

@Composable
fun ImageCard(title: String, content: String, imageUrl: String) {
    Box(
        modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).width(300.dp)
            .padding(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Placeholder",
                imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = title,
                fontSize = 28.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )
            Text(text = content, color = Color.DarkGray)
        }
    }
}

@Composable
fun ImageCardWithButton(title: String, content: String, imageUrl: String, buttonText: String) {
    Box(
        modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).width(300.dp)
            .padding(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Placeholder",
                imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = title,
                fontSize = 28.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )
            Text(text = content, color = Color.DarkGray)
            Button(
                onClick = {},
                modifier = Modifier.align(Alignment.End).padding(top = 16.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = buttonText)
            }
        }
    }
}

@Composable
fun ImageCardWithBadges(
    title: String,
    content: String,
    imageUrl: String,
    titleBadge: String,
    contentBadges: List<String>
) {
    Box(
        modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).width(300.dp)
            .padding(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Placeholder",
                imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 28.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier.border(width = 2.dp, Color.Red, RoundedCornerShape(50))
                        .padding(horizontal = 6.dp, vertical = 4.dp)
                ) {
                    Text(text = titleBadge, color = Color.Red, fontSize = 16.sp)
                }
            }
            Text(text = content, color = Color.DarkGray)
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                contentBadges.forEach {
                    Box(
                        modifier = Modifier.background(
                            Color.hsl(267F, 1f, 0.4f),
                            RoundedCornerShape(50)
                        ).padding(4.dp)
                    ) {
                        Text(text = it, color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun CardWithSideImage(title: String, content: String, imageUrl: String) {
    Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).width(300.dp)) {
        Row(modifier = Modifier.clip(RoundedCornerShape(20.dp))) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Placeholder",
                imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = title,
                    fontSize = 20.sp
                )
                Text(text = content, color = Color(0xFF6b6b6b))
            }
        }
    }
}

@Composable
fun VideoCardYoutubeStyle(
    title: String,
    authorName: String,
    authorImage: String,
    views: String,
    time: String,
    length: String,
    imageUrl: String
) {
    Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp)).padding(20.dp)) {
        Column(modifier = Modifier.width(400.dp)) {
            Box(modifier = Modifier.padding(bottom = 8.dp)) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Placeholder",
                    imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                    modifier = Modifier.size(height = 240.dp, width = 400.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = length,
                    color = Color.White,
                    modifier = Modifier.padding(6.dp)
                        .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(2.dp))
                        .align(Alignment.BottomEnd).padding(4.dp)
                )
            }
            Row {
                AsyncImage(
                    model = authorImage,
                    contentDescription = "Placeholder",
                    imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                    modifier = Modifier.size(24.dp).clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(start = 8.dp).weight(1f)) {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = authorName, color = Color.DarkGray)
                    Row {
                        Text(text = "$views · $time", color = Color.DarkGray)
                    }
                }
            }
        }
    }
}

@Composable
fun VideoCard(
    title: String,
    summary: String,
    length: String,
    imageUrl: String,
    authorImage: String,
    authorName: String
) {
    Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp))) {
        Column(modifier = Modifier.width(400.dp)) {
            Box {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Placeholder",
                    imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                    modifier = Modifier.size(height = 240.dp, width = 400.dp)
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = length,
                    color = Color.White,
                    modifier = Modifier.padding(6.dp)
                        .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(50))
                        .align(Alignment.BottomStart).padding(8.dp),
                )
                Row(
                    modifier = Modifier.padding(6.dp)
                        .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(50))
                        .align(Alignment.BottomEnd).padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AsyncImage(
                        model = authorImage,
                        contentDescription = "Placeholder",
                        imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
                        modifier = Modifier.size(16.dp).clip(RoundedCornerShape(50)),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = authorName, color = Color.White)
                }
            }
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = summary,
                    color = Color(0xFF6b6b6b),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun PricingCard(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    features: List<String> = listOf(
        "All analytical features",
        "Up to 5,000 visits per day",
        "Up to 3 team members",
        "Normal support"
    ),
    primaryColor: Color = Color(0xFF751dc2),
    forText: String,
    planNameText: String,
    description: String,
    price: Int
) {
    Column(
        modifier = modifier.width(250.dp).background(Color.White, RoundedCornerShape(20.dp))
            .padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.background(
                    Color.LightGray.copy(alpha = 0.2f),
                    RoundedCornerShape(5.dp)
                ).padding(10.dp)
            ) {
                Icon(
                    painterResource(icon),
                    "",
                    tint = primaryColor,
                    modifier = Modifier.size(32.dp)
                )
            }
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(forText, color = Color(0xFF6b6b6b))
                Text(planNameText, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            }
        }
        Text(description, color = Color(0xFF6b6b6b))
        Row(verticalAlignment = Alignment.Bottom) {
            Text("$$price", fontSize = 40.sp, fontWeight = FontWeight.Bold)
            Text("/monthly", color = Color(0xFF6b6b6b))
        }
        Text("What's included?", fontWeight = FontWeight.Bold)

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            features.forEach {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        Icons.Default.CheckCircle,
                        "",
                        tint = primaryColor,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(it)
                }
            }
        }
        Button(
            onClick = {},
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50)
        ) {
            Text(
                "Get Started",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun CardWithImageAndButton(modifier: Modifier = Modifier, imageUrl: String, title: String, content: String, buttonText: String) {
    Column(
        modifier = Modifier.width(300.dp).background(Color.White, RoundedCornerShape(20.dp))
            .padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Placeholder",
            imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
            modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Row {
            Text(title, fontSize = 20.sp)
        }
        Text(
            content,
            color = Color(0xFF6b6b6b)
        )
        Row {
            Spacer(modifier=Modifier.weight(1f))
            Button(onClick = {}, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2157eb), contentColor = Color.White), shape = RoundedCornerShape(10.dp)) {
                Text(buttonText, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun CardWithImage(modifier: Modifier = Modifier, imageUrl: String, title: String, content: String) {
    Column(
        modifier = Modifier.width(300.dp).background(Color.White, RoundedCornerShape(20.dp))
            .padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Placeholder",
            imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
            modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Row {
            Text(title, fontSize = 20.sp)
        }
        Text(
            content,
            color = Color(0xFF6b6b6b)
        )
    }
}

@Composable
fun SaleCard(modifier: Modifier = Modifier, imageUrl: String) {
    Column(
        modifier = Modifier.width(300.dp).background(Color.White, RoundedCornerShape(20.dp))
            .padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Placeholder",
            imageLoader = ImageLoader(context = PlatformContext.INSTANCE),
            modifier = Modifier.fillMaxWidth().height(200.dp).clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Row {
            Text("Product Name", fontSize = 20.sp)
            Spacer(Modifier.weight(1f))
            Text("$39.99", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Text(
            "This is a basic description of a sale product. This product has these features, and looks stylish both on you, in your car and also in your living room.",
            color = Color(0xFF6b6b6b)
        )
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            Button(onClick = {}, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(contentColor = Color.Red, containerColor = Color.White), shape = RoundedCornerShape(10.dp)) {
                Text("Remove", textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            }
            Button(onClick = {}, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2157eb), contentColor = Color.White), shape = RoundedCornerShape(10.dp)) {
                Text("Purchase", textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun AccessCard(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.width(300.dp).background(Color.White, RoundedCornerShape(20.dp))
        .padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painterResource(Res.drawable.alert_triangle), "Alert Icon", tint = Color(0xFF2157eb), modifier = Modifier.padding(10.dp).size(32.dp))
            Text("Permission required", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
        Text("You do not have permission to access this resource. \n\nPlease contact the owner for permission.", color = Color(0xFF6b6b6b))
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            Button(onClick = {}, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(contentColor = Color.Red, containerColor = Color.White), shape = RoundedCornerShape(10.dp)) {
                Text("Cancel", textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            }
            Button(onClick = {}, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2157eb), contentColor = Color.White), shape = RoundedCornerShape(10.dp)) {
                Text("Okay", textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            }
        }
    }
}