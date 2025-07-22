package com.android.jetpacklearning.UserInterface

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.jetpacklearning.ui.theme.JetpackLearningTheme
import java.nio.file.WatchEvent


@Composable
fun Greeting(name: String){
    Text(
        text = "Hello, $name",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(top = 20.dp)
        )
}

@Composable
fun TextAndButton(name: MutableState<String>,
                  nameEntered: MutableState<Boolean>){
    Row(modifier = Modifier.padding(top=48.dp))
    {
        TextField(
            value = name.value,
            onValueChange = {
                name.value = it },

            placeholder = {
                Text("Enter your name") },

            modifier = Modifier
                .alignByBaseline()
                .weight(1.0F),

            singleLine = true,

            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Done),

            keyboardActions = KeyboardActions(onDone={
                nameEntered.value = true
            } )
        )
    }
}

@Composable
fun Hello(nameText: String){
    val name = remember { mutableStateOf("") }
    val nameEntered = remember { mutableStateOf(false) }

    Greeting(nameText)
    TextAndButton(name, nameEntered)
}
