package com.brentcodes.campose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UsernameField(modifier: Modifier = Modifier) {
    var usernameValue by remember { mutableStateOf("") }
    Column(modifier = modifier.width(300.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Username", color = Color.DarkGray)
        OutlinedTextField(
            value = usernameValue,
            onValueChange = {usernameValue = it},
            maxLines = 1,
            placeholder = {Text("Username...")},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )
    }
}

@Composable
fun PasswordField(modifier: Modifier = Modifier) {
    var passwordValue by remember { mutableStateOf("") }
    val visiblePassword = remember { mutableStateOf(false) }
    Column(modifier = modifier.width(300.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text("Password", color = Color.DarkGray)
        OutlinedTextField(
            value = passwordValue,
            onValueChange = {passwordValue = it},
            maxLines = 1,
            placeholder = {Text("Password...")},
            trailingIcon = {
                IconButton(onClick = { visiblePassword.value = !visiblePassword.value }) {
                    if (visiblePassword.value) Icon(Icons.Default.Visibility, "Eye Icon") else Icon(Icons.Default.VisibilityOff, "Eye Icon")
                }
            },
            visualTransformation = if (!visiblePassword.value) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )
    }
}

@Composable
fun BasicSignin(modifier: Modifier = Modifier, title: String = "Sign in", subtitle: String = "Enter your details to sign into your account") {
    var usernameValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    val visiblePassword = remember { mutableStateOf(false) }
    Column(modifier = modifier.width(300.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(text = title, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
        Text(text = subtitle, fontSize = 18.sp, color = Color.DarkGray)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Username", color = Color.DarkGray)
        OutlinedTextField(
            value = usernameValue,
            onValueChange = {usernameValue = it},
            maxLines = 1,
            placeholder = {Text("Username...")},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )

        Text("Password", color = Color.DarkGray)
        OutlinedTextField(
            value = passwordValue,
            onValueChange = {passwordValue = it},
            maxLines = 1,
            placeholder = {Text("Password...")},
            trailingIcon = {
                IconButton(onClick = { visiblePassword.value = !visiblePassword.value }) {
                    if (visiblePassword.value) Icon(Icons.Default.Visibility, "Eye Icon") else Icon(Icons.Default.VisibilityOff, "Eye Icon")
                }
            },
            visualTransformation = if (!visiblePassword.value) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
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

@Composable
fun BasicSignup(modifier: Modifier = Modifier, title: String = "Sign Up", subtitle: String = "Enter your details to create a new account") {
    var usernameValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var confirmPasswordValue by remember { mutableStateOf("") }
    val visiblePassword = remember { mutableStateOf(false) }
    Column(modifier = modifier.width(300.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(text = title, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
        Text(text = subtitle, fontSize = 18.sp, color = Color.DarkGray)

        Spacer(modifier = Modifier.height(20.dp))

        Text("Username", color = Color.DarkGray)
        OutlinedTextField(
            value = usernameValue,
            onValueChange = {usernameValue = it},
            maxLines = 1,
            placeholder = {Text("Username...")},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )

        Text("Password", color = Color.DarkGray)
        OutlinedTextField(
            value = passwordValue,
            onValueChange = {passwordValue = it},
            maxLines = 1,
            placeholder = {Text("Password...")},
            trailingIcon = {
                IconButton(onClick = { visiblePassword.value = !visiblePassword.value }) {
                    if (visiblePassword.value) Icon(Icons.Default.Visibility, "Eye Icon") else Icon(Icons.Default.VisibilityOff, "Eye Icon")
                }
            },
            visualTransformation = if (!visiblePassword.value) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )

        Text("Confirm Password", color = Color.DarkGray)
        OutlinedTextField(
            value = confirmPasswordValue,
            onValueChange = {confirmPasswordValue = it},
            maxLines = 1,
            placeholder = {Text("Confirm Password...")},
            trailingIcon = {
                IconButton(onClick = { visiblePassword.value = !visiblePassword.value }) {
                    if (visiblePassword.value) Icon(Icons.Default.Visibility, "Eye Icon") else Icon(Icons.Default.VisibilityOff, "Eye Icon")
                }
            },
            visualTransformation = if (!visiblePassword.value) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("Sign Up")
        }
    }
}