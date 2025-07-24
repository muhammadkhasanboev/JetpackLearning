package com.android.jetpacklearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.android.jetpacklearning.UserInterface.Greeting
import com.android.jetpacklearning.UserInterface.Hello


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val name =  mutableStateOf("")
        val nameEntered = mutableStateOf(false)
        setContent {

        }
    }
}