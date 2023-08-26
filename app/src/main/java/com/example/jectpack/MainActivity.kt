package com.example.jectpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            preview()
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun preview() {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Welcome,", fontWeight = FontWeight.Bold, fontSize = 25.sp)
            Text(text = "Sign in to Continue,", fontSize = 19.sp)
            EmailField()
            PasswordField()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EmailField() {
        var state by remember { mutableStateOf("") }

        OutlinedTextField(
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            value = state,
            onValueChange = { state = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth(),
            )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PasswordField() {
        var state by remember { mutableStateOf("") }

        OutlinedTextField(
            visualTransformation= VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            value = state,
            onValueChange = { state = it },
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth(),

            )
    }
}