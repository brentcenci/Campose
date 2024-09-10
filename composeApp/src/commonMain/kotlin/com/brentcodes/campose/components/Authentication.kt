package com.brentcodes.campose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BasicSignin(modifier: Modifier = Modifier, title: String = "Sign in", subtitle: String = "Enter your details to sign into your account") {
    var usernameValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    val visiblePassword = remember { mutableStateOf(false) }
    Column(modifier = modifier.width(300.dp)) {
        Text(text = title, fontSize = 30.sp, color = Color.DarkGray)
        Text(text = subtitle, color = Color.LightGray)

        Spacer(modifier = Modifier.height(10.dp))

        Text("Username", color = Color.DarkGray)
        OutlinedTextField(
            value = usernameValue,
            onValueChange = {usernameValue = it},
            placeholder = {Text("Username...")}
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("Password", color = Color.DarkGray)
        OutlinedTextField(
            value = passwordValue,
            onValueChange = {passwordValue = it},
            placeholder = {Text("Password...")},
            trailingIcon = {
                IconButton(onClick = { visiblePassword.value = !visiblePassword.value }) {
                    if (visiblePassword.value) Icon(Icons.Default.Visibility, "Eye Icon") else Icon(Icons.Default.VisibilityOff, "Eye Icon")
                }
            },
            visualTransformation = if (!visiblePassword.value) PasswordVisualTransformation() else VisualTransformation.None
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { }
        ) {
            Text("Sign In")
        }
        Text(
            text = "Forgot your password?",
            color = Color.LightGray,
            modifier = Modifier.clickable {  }
        )
    }
}