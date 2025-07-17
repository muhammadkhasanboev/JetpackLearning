package com.android.jetpacklearning

import android.R.attr.value
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.jetpacklearning.ui.theme.JetpackLearningTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val name = remember { mutableStateOf("") }
            val nameEntered = remember { mutableStateOf(false) }

            Hello()


        }
    }
}
@Composable
fun greeting(name : String){
    Text(
        text="Hello $name",
        style=MaterialTheme.typography.headlineMedium,
        textAlign = TextAlign.Center)
}

@Composable
fun TextAndButton(name: MutableState<String>, nameEntered: MutableState<Boolean>){
    Row( modifier = Modifier.padding(top=8.dp) ){

        TextField(
            value = name.value,
            onValueChange = {name.value = it},
            placeholder = {
                Text("enter your name")
            },
            modifier = Modifier.alignByBaseline().weight(1.0F),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                capitalization = KeyboardCapitalization.Words,
            ),
            keyboardActions = KeyboardActions(onAny = {
                nameEntered.value=true
            })

        )
        Button(
            modifier = Modifier.alignByBaseline().padding(8.dp),
            onClick = {
                nameEntered.value = true
            }
        ){
            Text("Done")
        }
    }
}
@Composable
fun Hello(){
    val name = remember{mutableStateOf("")}
    val nameEntered= remember {mutableStateOf(false)}

    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ){
       if(nameEntered.value){
           greeting(name.value)
       }else{
           Column(
               horizontalAlignment = Alignment.CenterHorizontally
           ){
               Text("Welcome")
               TextAndButton(name,nameEntered)
           }
       }
    }
}
