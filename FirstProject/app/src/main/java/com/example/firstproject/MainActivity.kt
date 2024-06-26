package com.example.firstproject

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

import com.example.firstproject.ui.theme.FirstProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstProjectTheme {
                Greeting(greeting = "Mushahid")
            }
        }
    }
}


@Composable
fun Greeting(greeting: String) {
    val imageModifer = Modifier
        .size(150.dp)
        .border(BorderStroke(1.dp,Color.Black))
        .background(Color.Cyan).clip(CircleShape)
    val state = remember{mutableStateOf("")}
    Column {
        Text(
            text = "Hello, Welcome back $greeting",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            letterSpacing = 1.sp,
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.pic),
            contentDescription = "Dummy image",
//            Modifier.height(100.dp),
//            colorFilter = ColorFilter.tint(Color.Cyan)
            contentScale = ContentScale.Crop,
            modifier = imageModifer,

        )

        Button(
            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.Blue

            )
        ) {
            Row {

                Text(
                    text = "Click me",
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = R.drawable.pic),
                    contentDescription = "just a button",
                    Modifier.height(50.dp),
                    contentScale = ContentScale.FillHeight,


                )
            }
        }
        TextField(

            value = state.value,
            onValueChange = {
                state.value=it
            },
            placeholder = { Text(text = "This is a text field") }
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewGreeting() {
    Greeting(greeting = "Mushahid")
}