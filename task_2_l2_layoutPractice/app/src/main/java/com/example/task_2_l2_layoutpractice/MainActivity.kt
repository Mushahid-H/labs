package com.example.task_2_l2_layoutpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task_2_l2_layoutpractice.ui.theme.Task_2_l2_layoutPracticeTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task_2_l2_layoutPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Layoutt("Blade Runner", "A very great movie!",painterResource(id = R.drawable.blade))
                        Layoutt("Black Panther", "good movie, with wakanda!",painterResource(id = R.drawable.blackpanter))
                        Layoutt("Avengers Endgame", "Spooiler alert, thanos dies",painterResource(id = R.drawable.endgame))
                        Layoutt("Guardians of the Galaxy", "I am groot",painterResource(id = R.drawable.gotg))
                    }

                }
            }
        }
    }
}

@Composable
fun Layoutt(name: String, desc:String, painter: Painter, modifier: Modifier = Modifier) {

    Card(modifier = Modifier.padding(16.dp)) {
        Row(modifier = modifier) {
            Image(
                painter = painter,
                contentDescription = "Blade runner pic",
                modifier = Modifier.size(100.dp).clip(
                    RoundedCornerShape(10.dp)
            ).padding(10.dp),)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start

            ) {
                Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = desc, fontSize = 16.sp)
            }
        }
    }
}

