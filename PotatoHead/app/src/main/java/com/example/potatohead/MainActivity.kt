package com.example.potatohead

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.potatohead.ui.theme.PotatoHeadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PotatoHeadTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PotatoUI()
                }
            }
        }
    }
}

@Composable
fun PotatoUI() {
    var checkIt1 = remember{mutableStateOf(false)}
    var checkIt2 = remember{mutableStateOf(false)}
    var checkIt3 = remember{mutableStateOf(false)}
    var checkIt4 = remember{mutableStateOf(false)}
    var checkIt5 = remember{mutableStateOf(false)}
    var checkIt6 = remember{mutableStateOf(false)}
    var checkIt7 = remember{mutableStateOf(false)}
    var checkIt8 = remember{mutableStateOf(false)}
    var checkIt9 = remember{mutableStateOf(false)}
    var checkIt0 = remember{mutableStateOf(false)}


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,


    ) {
        Text(text = "Mr. Potato Head", fontSize = 32.sp)


        Text(text = "Check parts to add/remove them")
        Spacer(modifier = Modifier.height(20.dp));
//        i want to give height in between text and row widget



        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {

            Row {
                Checkbox(checked = checkIt1.value, onCheckedChange = {
                    isChecked -> checkIt1.value = isChecked

                })
                Text(text = "Hat")
            }

            Row {
                Checkbox(checked = checkIt2.value, onCheckedChange = {
                        isChecked -> checkIt2.value = isChecked
                })
                Text(text = "Eyes")
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {

            Row {
                Checkbox(checked = checkIt3.value, onCheckedChange = {
                    isChecked -> checkIt3.value = isChecked
                })
                Text(text = "" +
                        "Eyebrows")
            }

            Row {
                Checkbox(checked = checkIt4.value, onCheckedChange = {isChecked -> checkIt4.value = isChecked})
                Text(text = "Glasses")
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {

            Row {
                Checkbox(checked = checkIt5.value, onCheckedChange = {isChecked -> checkIt5.value = isChecked})
                Text(text = "Nose")
            }

            Row {
                Checkbox(checked = checkIt6.value, onCheckedChange = {isChecked -> checkIt6.value = isChecked})
                Text(text = "Mouth")
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {

            Row {
                Checkbox(checked = checkIt7.value, onCheckedChange = {isChecked -> checkIt7.value = isChecked})
                Text(text = "Mustache")
            }

            Row {
                Checkbox(checked = checkIt8.value, onCheckedChange = {isChecked -> checkIt8.value = isChecked})
                Text(text = "Ears")
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {

            Row {
                Checkbox(checked = checkIt9.value, onCheckedChange = {isChecked -> checkIt9.value = isChecked})
                Text(text = "Arms")
            }

            Row {
                Checkbox(checked = checkIt0.value, onCheckedChange = {isChecked -> checkIt0.value = isChecked})
                Text(text = "Shoes")
            }

        }
// potatohead task
        Box(contentAlignment = Alignment.TopCenter , modifier = Modifier.fillMaxSize(),){
            Image(
                painter = painterResource(id = R.drawable.body),
                contentDescription = "potato",
                Modifier.size(200.dp),


            );
            if (checkIt1.value) {
                Image(
                    painter = painterResource(id = R.drawable.hat),
                    contentDescription = "hat",
                    Modifier.size(100.dp),
                    alignment = Alignment.TopCenter
                )
            }
            if (checkIt2.value) {
                Spacer(modifier =Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.eyes),
                    contentDescription = "eyes",
                    modifier = Modifier.size(50.dp).offset(x = 0.dp, y = 35.dp)
                )
            }
            if (checkIt3.value) {


                Image(
                    painter = painterResource(id = R.drawable.eyebrows),
                    contentDescription = "eyebrows",

                    modifier = Modifier.size(60.dp).offset(x = 0.dp, y = 15.dp)
                )
            }
            if (checkIt4.value) {
                Image(
                    painter = painterResource(id = R.drawable.glasses),
                    contentDescription = "glasses",
                    modifier = Modifier.size(70.dp).offset(x = 0.dp, y = 25.dp).size(90.dp)
                )
            }
            if (checkIt5.value) {

                Image(
                    painter = painterResource(id = R.drawable.nose),
                    contentDescription = "nose",
                    modifier = Modifier.size(50.dp).offset(x = 0.dp, y = 60.dp)
                )
            }
            if (checkIt6.value) {

                Image(
                    painter = painterResource(id = R.drawable.mouth),
                    contentDescription = "mouth",
                    modifier = Modifier.size(60.dp).offset(x = 0.dp, y = 80.dp)
                )
            }
            if (checkIt7.value) {

                Image(
                    painter = painterResource(id = R.drawable.moustache),
                    contentDescription = "mustache",
                    modifier = Modifier.size(60.dp).offset(x = 0.dp, y = 70.dp)
                )
            }
            if (checkIt8.value) {

                Image(
                    painter = painterResource(id = R.drawable.ears),
                    contentDescription = "ears",
                    modifier = Modifier.size(100.dp).offset(x = 0.dp, y = 10.dp)
                )
            }
            if (checkIt9.value) {

                Image(
                    painter = painterResource(id = R.drawable.arms),
                    contentDescription = "arms",
                    modifier = Modifier.size(160.dp).offset(x = 0.dp, y = 55.dp)
                )
            }
            if (checkIt0.value) {

                Image(
                    painter = painterResource(id = R.drawable.shoes),
                    contentDescription = "shoes",
                    modifier = Modifier.size(110.dp).offset(x = -5.dp, y = 155.dp)
                )
            }
        }




    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PotatoHeadTheme {
        PotatoUI()
    }
}
