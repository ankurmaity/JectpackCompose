package com.example.jectpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class LoginActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Preview()
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun Preview() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Welcome,", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Text(
                text = "Sign in to Continue,",
                fontSize = 19.sp,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 50.dp)
            )
            EmailField()
            PasswordField()
            LoginButton()
            RememberMe()
            Register()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EmailField() {
        var email by remember { mutableStateOf("") }

        OutlinedTextField(
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
            ),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 10.dp)
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PasswordField() {
        var password by remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }

        OutlinedTextField(visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                val image = if (isPasswordVisible) R.drawable.ic_password_show
                else R.drawable.ic_password_show

                val description = if (isPasswordVisible) "Hide password" else "Show password"
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(painter = painterResource(id = image), contentDescription = description)
                }
            })
    }

    @Composable
    private fun LoginButton() {
        Button(
            onClick = {
                Toast.makeText(this@LoginActivity, "Login Clicked", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(0.dp, 15.dp, 0.dp, 0.dp),
            shape = RoundedCornerShape(5)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .width(10.dp)
                        .background(Color.White)
                )
                Text(
                    text = "Login",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)
                )
                Spacer(Modifier.fillMaxHeight())
                Icon(
                    painter = painterResource(id = R.drawable.ic_forward),
                    contentDescription = "Login",
                    tint = Color.White
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun RememberMe() {
        var isRemember = remember { mutableStateOf(false) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(0.dp, 15.dp)
        ) {
            CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                Checkbox(
                    checked = isRemember.value,
//                modifier = Modifier.absoluteOffset((-12).dp, 0.dp),
                    onCheckedChange = { isRemember.value = it })
            }
            Text(
                text = "Remember Me",
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(20.dp, 0.dp)
            )
        }
    }

    @Composable
    private fun Register() {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 15.dp, 0.dp, 0.dp)
        ) {
            Text(text = "You don't have an account?", color = Color.Gray)
            Text(text = "Register", color = Color.Blue, modifier = Modifier.clickable(onClick = {
                Toast.makeText(this@LoginActivity, "Register Clicked", Toast.LENGTH_LONG).show()
            }))
        }
    }

}