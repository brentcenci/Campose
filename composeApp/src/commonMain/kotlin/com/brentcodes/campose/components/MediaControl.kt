package com.brentcodes.campose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import campose.composeapp.generated.resources.Res
import campose.composeapp.generated.resources.favorite_filled
import campose.composeapp.generated.resources.favorite_outline
import campose.composeapp.generated.resources.pause
import campose.composeapp.generated.resources.play
import campose.composeapp.generated.resources.repeat
import campose.composeapp.generated.resources.repeat_1
import campose.composeapp.generated.resources.shuffle
import campose.composeapp.generated.resources.skip_back
import campose.composeapp.generated.resources.skip_forward
import org.jetbrains.compose.resources.painterResource

@Composable
fun BasicMusicControls(modifier: Modifier = Modifier) {
    var sliderValue by remember { mutableStateOf(0f) }
    var isPlaying by remember { mutableStateOf(false) }
    var shuffle by remember { mutableStateOf(0) }
    var liked by remember { mutableStateOf(false) }

    Column(modifier = modifier.width(300.dp)) {
        Column {
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { shuffle = (shuffle + 1) % 3 }) {
                Icon(if (shuffle == 0) painterResource(Res.drawable.shuffle) else if (shuffle == 1) painterResource(Res.drawable.repeat) else painterResource(Res.drawable.repeat_1), "Shuffle State" )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}) {
                Icon(painterResource(Res.drawable.skip_back), "Back")
            }
            IconButton(
                onClick = { isPlaying = !isPlaying},
                colors = IconButtonDefaults.filledIconButtonColors(containerColor = Color(0xFF1140bf), contentColor = Color.White)
            ) {
                Icon(if (isPlaying) painterResource(Res.drawable.pause) else painterResource(Res.drawable.play), "Play or Pause Button")
            }
            IconButton(onClick = {}) {
                Icon(painterResource(Res.drawable.skip_forward), "Forward")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { liked = !liked}) {
                Icon(if (liked) painterResource(Res.drawable.favorite_filled) else painterResource(Res.drawable.favorite_outline), "Like", modifier = Modifier.size(24.dp))
            }
        }
    }
}