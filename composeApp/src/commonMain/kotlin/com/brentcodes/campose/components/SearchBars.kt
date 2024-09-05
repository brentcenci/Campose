package com.brentcodes.campose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BasicSearchBar(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        leadingIcon = {
            Icon(Icons.Default.Search, "Search Icon")
        },
        maxLines = 1,
        modifier = modifier
    )
}

@Composable
fun RoundedSearchBar(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        placeholder = {
            Text(text= "Search...")
        },
        leadingIcon = {
            Icon(Icons.Default.Search, "Search Icon")
        },
        trailingIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.MoreVert, "More Vert Icon")
            }
        },
        maxLines = 1,
        shape = RoundedCornerShape(50),
        modifier = modifier
    )
}

@Composable
fun SearchBarWithSuggestions(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }
    val foods = listOf(
        "Apple", "Banana", "Carrot", "Tomato", "Potato", "Orange", "Strawberry", "Blueberry", "Broccoli", "Spinach",
        "Cucumber", "Onion", "Garlic", "Pepper", "Mushroom", "Lettuce", "Zucchini", "Eggplant", "Avocado", "Pineapple",
        "Mango", "Peach", "Pear", "Plum", "Kiwi", "Grapes", "Cherry", "Watermelon", "Cantaloupe", "Papaya",
        "Pumpkin", "Sweet Potato", "Radish", "Celery", "Asparagus", "Brussels Sprouts", "Cauliflower", "Corn", "Peas", "Green Beans",
        "Cabbage", "Kale", "Leek", "Beetroot", "Artichoke", "Bell Pepper", "Chili Pepper", "Bok Choy", "Turnip", "Parsley",
        "Rosemary", "Basil", "Thyme", "Oregano", "Cilantro", "Mint", "Dill", "Chives", "Lime", "Lemon",
        "Apricot", "Raspberry", "Blackberry", "Cranberry", "Pomegranate", "Fig", "Date", "Coconut", "Dragon Fruit", "Lychee",
        "Starfruit", "Passion Fruit", "Guava", "Tangerine", "Nectarine", "Rutabaga", "Parsnip", "Butternut Squash", "Acorn Squash", "Spaghetti Squash",
        "Yam", "Okra", "Snap Peas", "Edamame", "Fennel", "Shallot", "Scallion", "Jalapeño", "Habanero", "Serrano",
        "Chickpeas", "Lentils", "Black Beans", "Kidney Beans", "Quinoa", "Barley", "Brown Rice", "Oats", "Farro", "Couscous"
    )
    Column(modifier = modifier.width(300.dp)) {
        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            leadingIcon = {
                Icon(Icons.Default.Search, "Search Icon")
            },
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )
        Column(modifier = Modifier.background(Color.White)) {
            foods.filter { it.lowercase().contains(value.lowercase()) }.take(5).forEach { food ->
                HorizontalDivider()
                Row(modifier = Modifier.fillMaxWidth().clickable { value = food }.padding(5.dp)) { Text(text = food) }
            }
        }
    }
}

@Composable
fun SearchBarWithButton(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }
    Row(modifier = modifier.height(IntrinsicSize.Min), verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            placeholder = {
                Text(text= "Search...")
            },
            maxLines = 1,
            shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp),
            modifier = Modifier.fillMaxHeight()
        )
        IconButton(onClick = { }, modifier = Modifier.fillMaxHeight().background(color = Color(0xFF572de0), RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp)))  {
            Icon(Icons.Default.Search, "Search Button Icon", tint = Color.White)
        }
    }
}


