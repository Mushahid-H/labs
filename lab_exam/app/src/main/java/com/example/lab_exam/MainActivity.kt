package com.example.lab_exam

import Question
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab_exam.ui.theme.Lab_examTheme
import SplashScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_examTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp();
                }
            }
        }
    }
}

@Composable
fun MyApp() {


    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(Screen.SplashScreen.route) { SplashScreen(navController) }
        composable(Screen.qScreen.route) { QuestionScreen(navController) }
        composable(Screen.ResultScreen.route) {
            ResultScreen(
                correctAnswers = 0,
                totalQuestions=0
            )
        }

    }
    SplashScreen(navController)

    QuestionScreen(navController)

}
@Composable
fun ResultScreen(correctAnswers: Int, totalQuestions: Int) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "Quiz Results")
        Spacer(modifier = Modifier.padding(15.dp))

        Column {
            Text(text = "Quiz Results")
            Text(text = "Correct: $correctAnswers")
            Text(text ="Incorrect: ${totalQuestions - correctAnswers}")
            Text("Total $totalQuestions.")
            Text(text = "Earned points: ${correctAnswers * 10}")
            Text(text = "Overall points: ${totalQuestions * 10}")
            Text(text = "Date: ${Date().time}")

            Button(onClick = {  }, Modifier.fillMaxWidth()) {
                Text(text = "Start Again")
            }
        }
    }
}



@Composable
fun QuestionScreen(navController: NavController) {
    val context = LocalContext.current
    val resources = context.resources
    var correctAnswers = 0
    var correct=""



    // Fetching the questions
    val questions = mutableListOf<Question>()
    val questionTexts = listOf(
        R.string.question_1, R.string.question_2,  R.string.question_3, R.string.question_4, R.string.question_5
    )
    val optionArrays = listOf(
        R.array.options_question_1, R.array.options_question_2, R.array.options_question_3,R.array.options_question_4,R.array.options_question_5
    )
    val answerIndices = listOf(
        R.integer.answer_index_1, R.integer.answer_index_2, R.integer.answer_index_3, R.integer.answer_index_4,  R.integer.answer_index_5
    )
    val userAnswer = remember { mutableStateOf(false) }
    for (i in questionTexts.indices) {
        val questionText = resources.getString(questionTexts[i])
        val options = resources.getStringArray(optionArrays[i]).toList()
        val answerIndex = resources.getInteger(answerIndices[i])
        questions.add(Question(questionText, options, answerIndex, correct))
    }

    // State to keep track of the current question
    val currentQuestionIndex = remember { mutableStateOf(0) }

//     user selected answer


    // Display the current question
    val currentQuestion = questions[currentQuestionIndex.value]

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Column {
            Text(text = currentQuestion.questionText)
            for (i in currentQuestion.options.indices) {
                Row {
                    Checkbox(checked =  userAnswer.value, onCheckedChange = {
                        userAnswer.value = it

                    } )
                    Text(text = currentQuestion.options[i])
                }

            }

            Text(text = "Current Question ${currentQuestionIndex.value + 1}")
            Button(onClick = {
                if (currentQuestionIndex.value < questions.size - 1) {
                    if (currentQuestion.options[currentQuestion.userAnswer!!] == currentQuestion.options[currentQuestion.userAnswer!!]) {
                        correctAnswers++
                       correct=currentQuestion.options[currentQuestion.userAnswer!!]
                    }
                    currentQuestionIndex.value++
                }
                else{
                    navController.navigate(Screen.ResultScreen.route)
                }





            }) {
                Text("Next Question")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab_examTheme {
        MyApp()
    }
}