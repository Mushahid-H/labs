package com.example.task4_l2_lazygrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task4_l2_lazygrid.ui.theme.Task4_l2_lazygridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task4_l2_lazygridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyVerticalGrid()
                }
            }
        }
    }
}

@Composable
fun LazyVerticalGrid() {
    val imageList = listOf(
        R.drawable.blackpanter,
        R.drawable.blade,
        R.drawable.gotg,
        R.drawable.endgame,
        R.drawable.blackpanter,
        R.drawable.blade
    )
    val footerTextList = listOf(
        "Black Panther",
        "Blade",
        "Guardians of the Galaxy",
        "Endgame",
        "Black Panther",
        "Blade"
    )

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        itemsIndexed(imageList) { index, imageRes ->
            movieItems(index = index, imageRes = imageRes, footerText = footerTextList[index])
        }
    }
}



@Composable
fun movieItems(index: Int, imageRes: Int, footerText: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        val painter: Painter = painterResource(id = imageRes)
        Image(
            painter = painter,
            contentDescription = null, // Content description can be added if needed
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Adjust image height as needed
        )
        Spacer(modifier = Modifier.height(8.dp)) // Add space between image and footer
        Text(
            text = footerText,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}