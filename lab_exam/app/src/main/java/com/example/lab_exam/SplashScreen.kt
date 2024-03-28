import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost

import com.example.lab_exam.MainActivity
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

        // Add othe
    LaunchedEffect(Unit) {
        delay(3000) //Delay for 3 Seconds
        navController.navigate("questionScreen")
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text(
                text = "Welcome to",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Note-taking App",
                style = MaterialTheme.typography.headlineLarge
            )
        }

    }
}

