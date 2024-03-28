package com.example.numberguessgame

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.numberguessgame.ui.theme.NumberGuessGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumberGuessGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BuildUI();
                }
            }
        }
    }
}

val secretNo = Random.nextInt(1,100);
@Composable
fun BuildUI() {
    val textVal = remember{mutableStateOf("")};
    val result= remember {
        mutableStateOf("")
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = result.value
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(value = textVal.value, onValueChange ={
            textVal.value=it
        })
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = {

            val number = textVal.value
            if (number.toInt() > secretNo){
                result.value="TOO HIGH"
            }
            else if(number.toInt() < secretNo){
                result.value="TOO LOW"
            }
            else{
                result.value="Congratulations! You have guessed the number!"
            }

        }) {
            Text(text = "Validate")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NumberGuessGameTheme {
        BuildUI();
    }
}